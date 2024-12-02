/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agripro.backend.update;

import agripro.backend.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author angera
 */
public class UpdateDB {

    public static int updateUserApplication(String serial, String comments, String status) {
        String sql = "UPDATE subsidyApplication SET comments = ?, status = ? WHERE serialNo = ?";

        int rowsAffected = 0;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setString(1, comments);
            pstmt.setString(2, status);
            pstmt.setString(3, serial);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            // Handle SQLException and print the stack trace
            e.printStackTrace();
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }

    //setStatusDisbursed(serialNo)
    public static int setStatusDisbursed(String serialNo, String status) {
        String sql = "UPDATE subsidyApplication SET status = ? WHERE serialNo = ?";

        int rowsAffected = 0;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setString(1, status);
            pstmt.setString(2, serialNo);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            // Handle SQLException and print the stack trace
            e.printStackTrace();
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }

    public static int updateUserPassword(String email, String password) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";

        int rowsAffected = 0;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setString(1, password);
            pstmt.setString(2, email);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
// Handle SQLException and print the stack trace
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }

    public static int updateUserData(String email, String name, String phone) {
        String sql = "UPDATE users SET name = ?, phone = ? WHERE email = ?";

        int rowsAffected = 0;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            // Handle SQLException and print the stack trace
            e.printStackTrace();
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }

    //setStatusDisbursed(serialNo)
    public static int setStatusDisbursementInProgress(String subsidyId, String status) {
        String sql = "UPDATE subsidyApplication SET status = ? WHERE subsidyId = ? AND status = 'Approved'";

        int rowsAffected = -1;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setString(1, status);
            pstmt.setString(2, subsidyId);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
// Handle SQLException and print the stack trace
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }
    
    
    //setStatusDisbursed(serialNo)
    public static int updateAmountPaid(String serialNo, double amountPaid) {
        String sql = "UPDATE subsidyApplication SET amountPaid = amountPaid + ? WHERE serialNo = ?";

        int rowsAffected = -1;  // Store the number of rows affected
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Check if connection is null or closed
            if (conn == null || conn.isClosed()) {
                return rowsAffected;  // If connection is invalid, return 0 rows affected
            }

            // Set parameters for the query
            pstmt.setDouble(1, amountPaid);
            pstmt.setString(2, serialNo);

            // Execute the update and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
// Handle SQLException and print the stack trace
            rowsAffected = -1;  // Return -1 if an error occurs
        }

        return rowsAffected;  // Return the number of rows affected (0 or more) or -1 on error
    }

}
