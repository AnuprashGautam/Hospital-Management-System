package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Doctor {
    private static Connection connection;
    private static Scanner scanner;

    Doctor(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public static void viewDoctors() {
        try {
            String viewDoctorQuery = "SELECT * FROM doctors;";
            Statement stmt = connection.prepareStatement(viewDoctorQuery);

            ResultSet rs = stmt.executeQuery(viewDoctorQuery);

            System.out.println("|-----|--------------|----------------|");
            System.out.println("|  id |     name     | specialization |");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");
                System.out.println("|-----|--------------|----------------|");
                System.out.printf("| %-3s | %-12s | %-14s |\n", id, name, specialization);
                System.out.println("|-----|--------------|----------------|");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public static boolean checkDoctor(int doctorId, String date){
        try{
            String checkPatientQuery="SELECT * FROM appointment WHERE doctor_id=? AND appointment_date=? ;";
            PreparedStatement pstmt=connection.prepareStatement(checkPatientQuery);

            pstmt.setInt(1,doctorId);
            pstmt.setString(2,date);

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
