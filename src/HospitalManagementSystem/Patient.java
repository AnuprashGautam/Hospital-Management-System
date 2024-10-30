package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Patient
{

    private static Connection connection;
    private static Scanner scanner;
    Patient(Connection connection, Scanner scanner)
    {
        this.connection=connection;
        this.scanner=scanner;
    }

        public static void addPatient()
        {
            try {
                String addPatientQuery = "INSERT INTO patients(name,age,gender) VALUES (?,?,?);";
                PreparedStatement pstmt = connection.prepareStatement(addPatientQuery);

                System.out.println("Enter the patient name:");
                String name = scanner.next();
                System.out.println("Enter the patient age:");
                int age = scanner.nextInt();
                System.out.println("Enter the patient gender:");
                String gender = scanner.next();

                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, gender);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0)
                    System.out.println("Patient added successfully!!!");
                else
                    System.out.println("Patient data did not add.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void viewPatients ()
        {
            try {
                String viewPatientQuery = "SELECT * FROM patients;";
                Statement stmt = connection.prepareStatement(viewPatientQuery);

                ResultSet rs = stmt.executeQuery(viewPatientQuery);

                System.out.println("|-----|--------------|-----|--------|");
                System.out.println("|  id |     name     | age | gender |");
                System.out.println("|-----|--------------|-----|--------|");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    System.out.printf("| %-3s | %-12s | %-3s | %-6s |\n", id, name, age, gender);
                    System.out.println("|-----|--------------|-----|--------|");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    public static boolean checkPatient(int id, String name)
    {
        try{
            String checkPatientQuery="SELECT * FROM patients WHERE id=? AND name=?;";
            PreparedStatement pstmt=connection.prepareStatement(checkPatientQuery);

            pstmt.setInt(1,id);
            pstmt.setString(2,name);

            ResultSet rs=pstmt.executeQuery();

            if (rs.next()==true)
                return true;
            else
                return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
