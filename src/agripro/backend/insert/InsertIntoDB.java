package agripro.backend.insert;

import agripro.backend.connection.DatabaseConnection;
import agripro.backend.update.UpdateDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertIntoDB {    
    
    // Insert a new user
    public static void insertUser(String name, String email, String phone, String userRole) {
        String sql = "INSERT INTO users(name, email, phone, userRole) VALUES(?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, userRole);
            pstmt.executeUpdate();
            System.out.println("User " + email + " added with role: " + userRole);
        } catch (SQLException e) {
            System.err.println("Error adding user: " + email);
            e.printStackTrace();
        }
    }

    // Create a farmer profile
    public static boolean createFarmerProfile(String userId, String idNo, String subCounty, String address, 
                                           String location, String village, String plotNo) {
        String sql = "INSERT INTO farmers(userId, idNumber, address, subCounty, location, village, plotNumber) VALUES(?, ?, ?, ?, ?, ?, ?)";
        boolean created = false;
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, idNo);
            pstmt.setString(3, address);
            pstmt.setString(4, subCounty);
            pstmt.setString(5, location);
            pstmt.setString(6, village);
            pstmt.setString(7, plotNo);
            pstmt.executeUpdate();
            created = true;
            System.out.println("Profile for ID " + idNo + " created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating profile for ID " + idNo);
            e.printStackTrace();
        }
        return created;
    }
    
    
    // Create a farmer profile
    public static boolean createSupplierProfile(String userId, String idNo, String name, String location) {
        String sql = "INSERT INTO inputSuppliers(userId, idNumber, serialboardName, serialboardLocation) VALUES(?, ?, ?, ?)";
        boolean created = false;
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, idNo);
            pstmt.setString(3, name);
            pstmt.setString(4, location);
            pstmt.executeUpdate();
            created = true;
            System.out.println("Profile for Board " + name + " created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating profile for Board " + name);
            e.printStackTrace();
        }
        return created;
    }
    

    // Submit a subsidy application
    public static int makeApplication(String farmerId, String subsidyId, String quantity, String serialBoards, 
                                      double billed, String farmSize, String applicationType) {

        String serialNo = new SimpleDateFormat("yyyyMMdd").format(new Date()) + subsidyId + farmerId;
        String sql = "INSERT INTO subsidyApplication(farmerId, subsidyId, serialNo, quantity, NearestSerialBoards, AmountBilled, sizeOfFarm, applicationType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, farmerId);
            pstmt.setString(2, subsidyId);
            pstmt.setString(3, serialNo);
            pstmt.setString(4, quantity);
            pstmt.setString(5, serialBoards);
            pstmt.setDouble(6, billed);
            pstmt.setString(7, farmSize);
            pstmt.setString(8, "Subsequent Application".equals(applicationType) ? applicationType : "First Time Application");
            pstmt.executeUpdate();
            System.out.println("Application for subsidy " + subsidyId + " submitted.");
            return Integer.parseInt(serialNo);
        } catch (SQLException e) {
            System.err.println("Error applying for subsidy: " + subsidyId);
            e.printStackTrace();
            return -1;
        }
    }
    
    
    
    public static boolean disburseSubdidy(String serialNo, double amountPaid,String comments ,String serialboard){
        
        String sql = "INSERT INTO disbursedSubsidy(serialNo, amountPaid, comments, serialBoards) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, serialNo);
            pstmt.setDouble(2, amountPaid);
            pstmt.setString(3, comments);
            pstmt.setString(4, serialboard);
            pstmt.executeUpdate();
            
            UpdateDB.updateAmountPaid(serialNo, amountPaid);
            
            System.out.println("Disbursement for application " + serialNo + " submitted.");
            return true;
        } catch (SQLException e) {
            System.err.println("Error disbursing for application: " + serialNo);
            e.printStackTrace();
            return false;
        }
        
    }
}
