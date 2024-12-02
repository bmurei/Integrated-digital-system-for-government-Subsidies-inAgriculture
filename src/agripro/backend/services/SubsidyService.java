/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agripro.backend.services;

import agripro.backend.connection.DatabaseConnection;
import agripro.backend.retrieve.GetUserData;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsidyService {

    // Insert a new subsidy advertisement into the database
    public boolean insertSubsidyAdvertisement(String subsidyCategory, String subsidyType, String dueDate, double amountPerUnit, String quantity) {
        String sql = "INSERT INTO availableSubsidies (subsidyCategory, subsidyType, dueDate, amountPerUnit, quantity) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, subsidyCategory);
            pstmt.setString(2, subsidyType);
            pstmt.setString(3, dueDate);
            pstmt.setDouble(4, amountPerUnit);
            pstmt.setString(5, quantity);

            pstmt.executeUpdate();
            System.out.println("Subsidy advertisement created successfully.");
        } catch (SQLException e) {

            System.out.println("Failed to create subsidy advertisement.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Update the status of a subsidy advertisement
    public void updateSubsidyStatus(int subsidyId, String newStatus) {
        String sql = "UPDATE availableSubsidies SET subsidyStatus = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);
            pstmt.setInt(2, subsidyId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Subsidy status updated successfully.");
            } else {
                System.out.println("Subsidy not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update subsidy status.");
            e.printStackTrace();
        }
    }

    // Update the status of a subsidy advertisement
    public boolean updateSubsidyAdvertisement(int subsidyId, String date, double amount, String status, String quantity) {
        String sql = "UPDATE availableSubsidies SET subsidyStatus = ? , dueDate = ?, amountPerUnit = ?, quantity = ? WHERE id = ?";
        boolean updated = false;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setString(2, date);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, quantity);
            pstmt.setInt(5, subsidyId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                updated = true;
                System.out.println("Subsidy Information updated successfully.");
            } else {
                System.out.println("Subsidy not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update subsidy Information.");
            e.printStackTrace();
        }
        return updated;
    }

    // Extend the due date of a subsidy advertisement by a specific number of days
    public void extendSubsidyDueDate(int subsidyId, int additionalDays) {
        String sql = "UPDATE availableSubsidies SET dueDate = DATE(dueDate, ?) WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "+" + additionalDays + " days");
            pstmt.setInt(2, subsidyId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Subsidy due date extended successfully.");
            } else {
                System.out.println("Subsidy not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to extend subsidy due date.");
            e.printStackTrace();
        }
    }

    public static List<Object[]> getAvailableSubsidies() {
        List<Object[]> subsidies = new ArrayList<>();
        String sql = "SELECT * FROM availableSubsidies WHERE subsidyStatus = 'open'";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("subsidyCategory"),
                    rs.getString("subsidyType"),
                    rs.getString("dueDate"),
                    rs.getDouble("amountPerUnit")
                };
                subsidies.add(row);
            }
            System.out.println("Available subsidies retrieved successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve available subsidies.");
            e.printStackTrace();
        }

        return subsidies;
    }

    // Method to check if the farmer has already applied for the subsidy
    public static boolean hasFarmerAppliedForSubsidy(String farmerId, int subsidyId) {
        String sql = """
                SELECT COUNT(*) AS applicationCount 
                FROM subsidyApplication 
                WHERE farmerId = ? AND subsidyId = ?;
                """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, farmerId);
            pstmt.setInt(2, subsidyId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("applicationCount");
                return count > 0;  // Returns true if at least one application exists
            }
        } catch (SQLException e) {
            System.out.println("Failed to check subsidy application status.");
            e.printStackTrace();
        }
        return false; // Returns false if no application found or on error
    }

    // Retrieves a list of subsidy types based on the selected category
    public List<String> getSubsidyTypesByCategory(String category) {
        List<String> subsidyTypes = new ArrayList<>();
        String sql = "SELECT subsidyType FROM availableSubsidies WHERE subsidyCategory = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                subsidyTypes.add(rs.getString("subsidyType"));
            }
            System.out.println("Subsidy types retrieved successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve subsidy types.");
            e.printStackTrace();
        }

        return subsidyTypes;
    }

    // Retrieves details of a subsidy based on the selected type
    public Map<String, Object> getSubsidyDetailsByType(String type) {
        Map<String, Object> subsidyDetails = new HashMap<>();
        String sql = "SELECT subsidyCategory, dueDate, amountPerUnit FROM availableSubsidies WHERE subsidyType = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                subsidyDetails.put("subsidyCategory", rs.getString("subsidyCategory"));
                subsidyDetails.put("dueDate", rs.getString("dueDate"));
                subsidyDetails.put("amountPerUnit", rs.getDouble("amountPerUnit"));
            }
            System.out.println("Subsidy details retrieved successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve subsidy details.");
            e.printStackTrace();
        }

        return subsidyDetails;
    }
    
    
    
    public int getAdvertsCount() {
        String query = "SELECT COUNT(*) FROM availableSubsidies WHERE subsidyStatus = 'open'";
        return GetUserData.getCount(query);
    }

    public int getFarmerSubsidiesCount(String farmerId) {
        String query = "SELECT COUNT(*) FROM subsidyApplication WHERE farmerId = ? AND status = 'Disbursed'";
        return GetUserData.getCountWithParam(query, farmerId);
    }

    public int getApplicationsCount(String farmerId) {
        String query = "SELECT COUNT(*) FROM subsidyApplication WHERE farmerId = ?";
        return GetUserData.getCountWithParam(query, farmerId);
    }

    public int getRegisteredFarmersCount() {
        String query = "SELECT COUNT(*) FROM farmers";
        return GetUserData.getCount(query);
    }

    public int getDisbursementsCount() {
        String query = "SELECT COUNT(*) FROM disbursedSubsidy";
        return GetUserData.getCount(query);
    }

    public int getApprovedSuppliersCount() {
        String query = "SELECT COUNT(*) FROM inputSuppliers";
        return GetUserData.getCount(query);
    }

    public int getDisbursedCount(String serialboard) {
        String query = "SELECT COUNT(*) FROM disbursedSubsidy WHERE serialBoards = ?";
        return GetUserData.getCountWithParam(query, serialboard);
    }

    public int getInProgressDisbursementsCount(String serialboard) {
        String query = "SELECT COUNT(*) FROM subsidyApplication WHERE nearestSerialBoards = ? AND status = 'Disbursement In Progress'";
        return GetUserData.getCountWithParam(query, serialboard);
    }

    public int getAwaitingFarmersCount(String serialboard) {
        String query = "SELECT COUNT(*) FROM subsidyApplication WHERE nearestSerialBoards = ? AND status = 'Reviewing'";
        return GetUserData.getCountWithParam(query, serialboard);
    }

}
