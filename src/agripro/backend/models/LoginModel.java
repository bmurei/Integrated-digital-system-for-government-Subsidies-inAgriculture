package agripro.backend.models;

import agripro.backend.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    // Method to verify user credentials
    public static boolean authenticateUser(String email, String password) {
        String sql = "SELECT password FROM users WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, email); // Set email parameter
            ResultSet rs = pstmt.executeQuery(); // Execute query

            if (rs.next()) {
                String storedPassword = rs.getString("password"); // Fetch password from DB
                
                // Compare the provided password with the stored one
                if (password.equals(storedPassword)) {
                    return true; // Passwords match
                } else {
                    System.out.println("Incorrect password");
                    return false; // Passwords don't match
                }
            } else {
                System.out.println("User not found with email: " + email);
                return false; // User doesn't exist
            }

        } catch (SQLException e) {
            System.out.println("Error during authentication process.");
            e.printStackTrace();
            return false;
        }
    }
}
