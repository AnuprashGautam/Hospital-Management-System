package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {

    private static final String url="jdbc:mysql://localhost:3306/hospital";
    private static final String username="root";
    private static final String password="haveaniceday";

    public static Connection connection;
    static {
        try{
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully!!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static Scanner scanner=new Scanner(System.in);
    public static Patient patient=new Patient(connection,scanner);
    public static Doctor doctor=new Doctor(connection,scanner);

    public static void main(String [] args){

        int choice;

        // Loading the driver files
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // Menu
        while(true){
            System.out.println("Welcome to the Hospital Management System!!!");
            System.out.println();
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice:");
            choice= scanner.nextInt();

            switch(choice)
            {
                case 1:
                    patient.addPatient();
                    break;
                case 2:
                    patient.viewPatients();
                    break;
                case 3:
                    doctor.viewDoctors();
                    break;
                case 4:
                    HospitalManagementSystem.bookAppointment();
                    break;
                case 5:
                    System.out.println("Thanks for using the HOSPITAL MANAGEMENT SYSTEM.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void bookAppointment(){
        System.out.println("Enter the patient id:");
        int patientId=scanner.nextInt();
        System.out.println("Enter the patient name:");
        String patientName=scanner.next();

        if(!patient.checkPatient(patientId,patientName)){
            System.out.println("Patient does not exists. Please register the patient first.");
            patient.addPatient();
        }

        System.out.println("Enter the doctor id:");
        int doctorId=scanner.nextInt();
        System.out.println("Enter the appointment date in YYYY-MM-DD format:");
        String date=scanner.next();

        if(doctor.checkDoctor(doctorId,date)){
            System.out.println("Doctor is not free on this date.");
            return;
        }

        String bookAppointmentQuery="INSERT INTO appointment(patient_id,doctor_id,appointment_date) VALUES(?,?,?);";

        try{
            PreparedStatement pstmt=connection.prepareStatement(bookAppointmentQuery);

            pstmt.setInt(1,patientId);
            pstmt.setInt(2,doctorId);
            pstmt.setString(3,date);

            int rowsAffected =pstmt.executeUpdate();

            if(rowsAffected>0)
                System.out.println("Appointment booked.");
            else
                System.out.println("Appointment did not booked.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
