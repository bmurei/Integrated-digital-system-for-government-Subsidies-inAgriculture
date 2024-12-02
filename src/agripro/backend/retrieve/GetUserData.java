package agripro.backend.retrieve;

import agripro.backend.models.User;
import agripro.backend.connection.DatabaseConnection;
import agripro.backend.models.SubsidyRecord;
import agripro.dashboard.model.Farmer;
import agripro.dashboard.model.FarmerSubsidyApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import java.util.List;
import java.sql.Statement;

public class GetUserData {

    public static User getUserByEmail(String email) {
        String sqlUser = "SELECT * FROM users WHERE email = ?";
        String sqlFarmer = "SELECT * FROM farmers WHERE userId = ?";
        String sqlInputSupplier = "SELECT * FROM inputSuppliers WHERE userId = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Step 1: Retrieve the user data from the 'users' table
            try (PreparedStatement pstmtUser = conn.prepareStatement(sqlUser)) {
                pstmtUser.setString(1, email);
                ResultSet rsUser = pstmtUser.executeQuery();

                if (rsUser.next()) {
                    // Retrieve common user fields
                    String userId = rsUser.getString("id");
                    String name = rsUser.getString("name");
                    String phone = rsUser.getString("phone");
                    String password = rsUser.getString("password");
                    String userRole = rsUser.getString("userRole");

                    // Step 2: Check if the user is a farmer
                    if ("Farmer".equalsIgnoreCase(userRole)) {
                        // Retrieve farmer-specific data
                        try (PreparedStatement pstmtFarmer = conn.prepareStatement(sqlFarmer)) {
                            pstmtFarmer.setString(1, userId);
                            ResultSet rsFarmer = pstmtFarmer.executeQuery();

                            if (rsFarmer.next()) {
                                // Farmer fields
                                String farmerId = rsFarmer.getString("id");
                                String idNo = rsFarmer.getString("idNumber");
                                String subcounty = rsFarmer.getString("subCounty");
                                String locationName = rsFarmer.getString("location");
                                String villageName = rsFarmer.getString("village");
                                String plotNo = rsFarmer.getString("plotNumber");
                                String address = rsFarmer.getString("address");

                                // Create User as Farmer
                                user = new User(userId, name, email, phone, password, userRole, farmerId, idNo, subcounty, locationName, villageName, plotNo, address);
                                System.out.println("Farmer details loaded for: " + name);
                            } else {
                                user = new User(userId, name, email, phone, password, userRole, "-1", "ID", "SUBCOUNTY", "LOCATION", "VILLAGE", "NUMBER", "ADDRESS");
                                System.out.println("Farmer details not found for user: " + email);
                            }
                        }
                    } else if ("Serial Board Officer".equalsIgnoreCase(userRole)) {
                        // Retrieve farmer-specific data
                        try (PreparedStatement pstmtSupplier = conn.prepareStatement(sqlInputSupplier)) {
                            pstmtSupplier.setString(1, userId);
                            ResultSet rsSupplier = pstmtSupplier.executeQuery();

                            if (rsSupplier.next()) {
                                // Farmer fields
                                String supplierId = rsSupplier.getString("id");
                                String idNo = rsSupplier.getString("idNumber");
                                String serialboardName = rsSupplier.getString("serialboardName");
                                String locationName = rsSupplier.getString("serialboardLocation");

                                // Create User as Serial Board Supplier
                                //(String id, String name, String email, String phone, String password, String userRole, String sid, String boardName, String boardLocation)
                                user = new User(userId, name, email, phone, password, userRole, supplierId, idNo, serialboardName, locationName);

                                System.out.println("Serial Board Officer details loaded for: " + name);
                            } else {
                                user = new User(userId, name, email, phone, password, userRole, "-1", "ID", "SUBCOUNTY", "LOCATION", "VILLAGE", "NUMBER", "ADDRESS");
                                System.out.println("Serial Board Officer details not found for user: " + email);
                            }
                        }
                    } else {
                        // Create User as regular user
                        user = new User(userId, name, email, phone, password, userRole);
                        System.out.println("User found: " + name);
                    }
                } else {
                    System.out.println("No user found with email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user or farmer details.");
            e.printStackTrace();
        }

        return user;
    }

    // Method to fetch subsidy details for a specific farmer
    public static List<FarmerSubsidyApplication> getFarmerSubsidyDetails(String farmer) {
        List<FarmerSubsidyApplication> detailsList = new ArrayList<>();

        String sql = """
            SELECT 
                u.name AS farmerName, 
                f.id AS farmerId, 
                f.subCounty AS farmerSubCounty,
                sa.subsidyId AS subsidyId,
                sa.NearestSerialBoards AS serialBoards, 
                sa.sizeOfFarm AS farmSize, 
                asb.subsidyCategory, 
                asb.subsidyType, 
                sa.status AS applicationStatus, 
                sa.amountBilled, 
                sa.quantity, 
                sa.applicationDate, 
                sa.serialNo
            FROM 
                subsidyApplication sa
            JOIN 
                farmers f ON sa.farmerId = f.id
            JOIN 
                users u ON f.userId = u.id
            JOIN 
                availableSubsidies asb ON sa.subsidyId = asb.id
            WHERE 
                sa.farmerId = ?;
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, farmer);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FarmerSubsidyApplication detail = new FarmerSubsidyApplication();
                detail.setFarmerName(rs.getString("farmerName"));
                detail.setFarmerId(rs.getInt("farmerId"));
                detail.setFarmerSubCounty(rs.getString("farmerSubCounty"));
                detail.setSubsidyId(rs.getString("subsidyId"));
                detail.setSerialBoards(rs.getString("serialBoards"));
                detail.setFarmSize(rs.getString("farmSize"));
                detail.setSubsidyCategory(rs.getString("subsidyCategory"));
                detail.setSubsidyType(rs.getString("subsidyType"));
                detail.setApplicationStatus(rs.getString("applicationStatus"));
                detail.setAmountBilled(rs.getDouble("amountBilled"));
                detail.setQuantity(rs.getString("quantity"));
                detail.setApplicationDate(rs.getString("applicationDate"));
                detail.setSerialNo(rs.getString("serialNo"));

                detailsList.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve farmer subsidy details.");
            e.printStackTrace();
        }

        return detailsList;
    }

    // Method to fetch subsidy details for a specific farmer by serial number
    public static List<Farmer> getSubsidyDetails(String serial) {
        List<Farmer> detailsList = new ArrayList<>();

        // SQL query to fetch subsidy details
        String sql = """
        SELECT 
            u.name AS farmerName, 
            f.id AS farmerId, 
            f.subCounty AS farmerSubCounty,
            f.address AS address,
            f.location AS location,
            sa.subsidyId AS subsidyId,
            sa.NearestSerialBoards AS serialBoards, 
            sa.sizeOfFarm AS farmSize, 
            asb.subsidyCategory, 
            asb.subsidyType, 
            sa.status AS applicationStatus, 
            sa.amountBilled, 
            sa.quantity, 
            sa.applicationDate, 
            sa.serialNo
        FROM 
            subsidyApplication sa
        JOIN 
            farmers f ON sa.farmerId = f.id
        JOIN 
            users u ON f.userId = u.id
        JOIN 
            availableSubsidies asb ON sa.subsidyId = asb.id
        WHERE 
            sa.serialNo = ? AND sa.status = 'Reviewing' OR sa.status = 'Declined';
    """;

        // Debugging: Log the serial number being passed to ensure it's correct
        System.out.println("Fetching subsidy details for serial number: " + serial);

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, serial);  // Set the serial number parameter

            // Execute the query and process the result set
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if there are any results
                if (!rs.isBeforeFirst()) {
                    System.out.println("No subsidy details found for serial: " + serial);
                    return detailsList;  // Return empty list if no results
                }

                // Iterate through the result set and populate the list with Farmer objects
                while (rs.next()) {
                    Farmer detail = new Farmer();

                    // Populate the Farmer object with data from the result set
                    detail.setFarmerName(rs.getString("farmerName"));
                    detail.setFarmerId(rs.getInt("farmerId"));
                    detail.setFarmerSubCounty(rs.getString("farmerSubCounty"));
                    detail.setSubsidyId(rs.getString("subsidyId"));
                    detail.setSerialBoards(rs.getString("serialBoards"));
                    detail.setFarmSize(rs.getString("farmSize"));
                    detail.setSubsidyCategory(rs.getString("subsidyCategory"));
                    detail.setSubsidyType(rs.getString("subsidyType"));
                    detail.setApplicationStatus(rs.getString("applicationStatus"));
                    detail.setAmountBilled(rs.getDouble("amountBilled"));
                    detail.setQuantity(rs.getString("quantity"));
                    detail.setApplicationDate(rs.getString("applicationDate"));
                    detail.setSerialNo(rs.getString("serialNo"));
                    detail.setAddressLine(rs.getString("address"));
                    detail.setLocation(rs.getString("location"));

                    // Add the populated Farmer object to the list
                    detailsList.add(detail);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching subsidy details: " + e.getMessage());
            e.printStackTrace();
        }

        // Return the populated list of Farmer objects (may be empty if no results)
        return detailsList;
    }

    // Method to fetch subsidy details for a specific farmer by serial number
    public static List<Farmer> getConfirmedSubsidyDetails(String serial) {
        List<Farmer> detailsList = new ArrayList<>();

        // SQL query to fetch subsidy details
        String sql = """
        SELECT 
            u.name AS farmerName, 
            f.id AS farmerId, 
            f.subCounty AS farmerSubCounty,
            f.address AS address,
            f.location AS location,
            sa.subsidyId AS subsidyId,
            sa.NearestSerialBoards AS serialBoards, 
            sa.sizeOfFarm AS farmSize, 
            asb.subsidyCategory, 
            asb.subsidyType, 
            sa.status AS applicationStatus, 
            sa.amountBilled, 
            sa.quantity, 
            sa.applicationDate, 
            sa.serialNo
        FROM 
            subsidyApplication sa
        JOIN 
            farmers f ON sa.farmerId = f.id
        JOIN 
            users u ON f.userId = u.id
        JOIN 
            availableSubsidies asb ON sa.subsidyId = asb.id
        WHERE 
            sa.serialNo = ? AND sa.status = 'Disbursement In Progress';  -- Filtering by serialNo and 'Disbursement In Progress' status
    """;

        // Debugging: Log the serial number being passed to ensure it's correct
        System.out.println("Fetching subsidy details for serial number: " + serial);

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, serial);  // Set the serial number parameter

            // Execute the query and process the result set
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if there are any results
                if (!rs.isBeforeFirst()) {
                    System.out.println("No subsidy details found for serial: " + serial);
                    return detailsList;  // Return empty list if no results
                }

                // Iterate through the result set and populate the list with Farmer objects
                while (rs.next()) {
                    Farmer detail = new Farmer();

                    // Populate the Farmer object with data from the result set
                    detail.setFarmerName(rs.getString("farmerName"));
                    detail.setFarmerId(rs.getInt("farmerId"));
                    detail.setFarmerSubCounty(rs.getString("farmerSubCounty"));
                    detail.setSubsidyId(rs.getString("subsidyId"));
                    detail.setSerialBoards(rs.getString("serialBoards"));
                    detail.setFarmSize(rs.getString("farmSize"));
                    detail.setSubsidyCategory(rs.getString("subsidyCategory"));
                    detail.setSubsidyType(rs.getString("subsidyType"));
                    detail.setApplicationStatus(rs.getString("applicationStatus"));
                    detail.setAmountBilled(rs.getDouble("amountBilled"));
                    detail.setQuantity(rs.getString("quantity"));
                    detail.setApplicationDate(rs.getString("applicationDate"));
                    detail.setSerialNo(rs.getString("serialNo"));
                    detail.setAddressLine(rs.getString("address"));
                    detail.setLocation(rs.getString("location"));

                    // Add the populated Farmer object to the list
                    detailsList.add(detail);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching subsidy details: " + e.getMessage());
            e.printStackTrace();
        }

        // Return the populated list of Farmer objects (may be empty if no results)
        return detailsList;
    }

    // Method to fetch subsidy details for a specific farmer
    public static List<FarmerSubsidyApplication> getSubsidyApplications() {
        List<FarmerSubsidyApplication> detailsList = new ArrayList<>();

        String sql = """
            SELECT 
                u.name AS farmerName, 
                f.id AS farmerId, 
                f.subCounty AS farmerSubCounty,
                sa.subsidyId AS subsidyId,
                sa.NearestSerialBoards AS serialBoards, 
                sa.sizeOfFarm AS farmSize, 
                asb.subsidyCategory, 
                asb.subsidyType, 
                sa.status AS applicationStatus, 
                sa.amountBilled, 
                sa.quantity, 
                sa.applicationDate, 
                sa.serialNo
            FROM 
                subsidyApplication sa
            JOIN 
                farmers f ON sa.farmerId = f.id
            JOIN 
                users u ON f.userId = u.id
            JOIN 
                availableSubsidies asb ON sa.subsidyId = asb.id 
            WHERE 
                sa.status = 'Reviewing' OR sa.status = 'Declined';
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FarmerSubsidyApplication detail = new FarmerSubsidyApplication();
                detail.setFarmerName(rs.getString("farmerName"));
                detail.setFarmerId(rs.getInt("farmerId"));
                detail.setFarmerSubCounty(rs.getString("farmerSubCounty"));
                detail.setSubsidyId(rs.getString("subsidyId"));
                detail.setSerialBoards(rs.getString("serialBoards"));
                detail.setFarmSize(rs.getString("farmSize"));
                detail.setSubsidyCategory(rs.getString("subsidyCategory"));
                detail.setSubsidyType(rs.getString("subsidyType"));
                detail.setApplicationStatus(rs.getString("applicationStatus"));
                detail.setAmountBilled(rs.getDouble("amountBilled"));
                detail.setQuantity(rs.getString("quantity"));
                detail.setApplicationDate(rs.getString("applicationDate"));
                detail.setSerialNo(rs.getString("serialNo"));

                detailsList.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve farmer subsidy details.");
            e.printStackTrace();
        }

        return detailsList;
    }

    // Method to fetch subsidy details for a specific farmer
    public static List<FarmerSubsidyApplication> getSubsidyDisbursed(String serialboard) {
        List<FarmerSubsidyApplication> detailsList = new ArrayList<>();

        String sql = """
        SELECT 
            u.name AS farmerName, 
            f.id AS farmerId, 
            f.subCounty AS farmerSubCounty,
            sa.subsidyId AS subsidyId,
            sa.NearestSerialBoards AS serialBoards, 
            sa.sizeOfFarm AS farmSize, 
            asb.subsidyCategory, 
            asb.subsidyType, 
            sa.status AS applicationStatus, 
            sa.amountBilled, 
            sa.quantity, 
            sa.applicationDate, 
            sa.serialNo
        FROM 
            subsidyApplication sa
        JOIN 
            farmers f ON sa.farmerId = f.id
        JOIN 
            users u ON f.userId = u.id
        JOIN 
            availableSubsidies asb ON sa.subsidyId = asb.id 
        WHERE 
            sa.status = 'Disbursement In Progress' 
            AND sa.NearestSerialBoards LIKE ?
    """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the parameter for the LIKE clause with wildcard
            pstmt.setString(1, "%" + serialboard + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FarmerSubsidyApplication detail = new FarmerSubsidyApplication();
                detail.setFarmerName(rs.getString("farmerName"));
                detail.setFarmerId(rs.getInt("farmerId"));
                detail.setFarmerSubCounty(rs.getString("farmerSubCounty"));
                detail.setSubsidyId(rs.getString("subsidyId"));
                detail.setSerialBoards(rs.getString("serialBoards"));
                detail.setFarmSize(rs.getString("farmSize"));
                detail.setSubsidyCategory(rs.getString("subsidyCategory"));
                detail.setSubsidyType(rs.getString("subsidyType"));
                detail.setApplicationStatus(rs.getString("applicationStatus"));
                detail.setAmountBilled(rs.getDouble("amountBilled"));
                detail.setQuantity(rs.getString("quantity"));
                detail.setApplicationDate(rs.getString("applicationDate"));
                detail.setSerialNo(rs.getString("serialNo"));

                detailsList.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve farmer subsidy details.");
            e.printStackTrace();
        }

        return detailsList;
    }

    public static List<SubsidyRecord> getSubsidyRecords() {
        List<SubsidyRecord> records = new ArrayList<>();

        // SQL query to retrieve subsidy details, counting approved applications and summing their amount
        String sql = """
                        SELECT 
                            a.id AS subsidyID,
                            a.subsidyCategory,
                            a.subsidyType,
                            COUNT(sa.id) AS farmersApplied,
                            SUM(CASE 
                                    WHEN sa.status IN ('Approved', 'Disbursement In Progress','Disbursed') 
                                    THEN 1 
                                    ELSE 0 
                                END) AS approvedFarmers,
                     
                            SUM(CASE 
                                     WHEN sa.status IN ('Disbursement In Progress') 
                                        THEN 1 
                                        ELSE 0 
                                END) AS DisbursementInProgress,
                     
                            SUM(CASE 
                                    WHEN sa.status IN ('Disbursed') 
                                        THEN 1 
                                        ELSE 0 
                                END) AS Disbursed,
                     
                            SUM(CASE 
                                    WHEN sa.status IN ('Approved', 'Disbursement In Progress', 'Disbursed') 
                                    THEN sa.amountBilled 
                                    ELSE 0 
                                END) AS totalAmount
                        FROM 
                            availableSubsidies a
                        LEFT JOIN 
                            subsidyApplication sa ON a.id = sa.subsidyId
                        GROUP BY 
                            a.id, a.subsidyCategory, a.subsidyType
                        HAVING 
                            approvedFarmers > 0
                    """;

        try (Statement stmt = DatabaseConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int subsidyID = rs.getInt("subsidyID");
                String subsidyCategory = rs.getString("subsidyCategory");
                String subsidyType = rs.getString("subsidyType");
                int farmersApplied = rs.getInt("farmersApplied");
                int approvedFarmers = rs.getInt("approvedFarmers");
                int dInProgress = rs.getInt("DisbursementInProgress");
                int fDisbursed = rs.getInt("Disbursed");
                double totalAmount = rs.getDouble("totalAmount");

                records.add(new SubsidyRecord(subsidyID, subsidyCategory, subsidyType, farmersApplied, approvedFarmers, dInProgress, fDisbursed, totalAmount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    // Method to get data from AdvertisedSubsidies view
    public static List<List<Object>> getAdvertised() {
        String query = "SELECT * FROM AdvertisedSubsidies";
        return fetchData(query);
    }

    public static List<List<Object>> getRegisteredFarmers() {
        return queryView("SELECT * FROM RegisteredFarmers");
    }

    // Method to get data from ApprovedApplications view
    public static List<List<Object>> getApproved() {
        String query = "SELECT * FROM ApprovedApplications";
        return fetchData(query);
    }

    public static List<List<Object>> getDeclinedApplications() {
        return queryView("SELECT * FROM DeclinedApplications");
    }

    public static List<List<Object>> getDisbursements() {
        return queryView("SELECT * FROM Disbursements");
    }

    public static List<List<Object>> getAdvertisedSubsidies() {
        return queryView("SELECT * FROM AdvertisedSubsidies");
    }

    public static List<List<Object>> getAppliedFarmers() {
        return queryView("SELECT * FROM AppliedFarmers");
    }

    public static List<List<Object>> getApprovedSubsidies() {
        return queryView("SELECT * FROM ApprovedApplications");
    }

    public static List<List<Object>> getSerialBoardAppliedFarmers(String boardname) {
        return queryView("SELECT * FROM FarmerSubsidyDetails WHERE serialBoards LIKE '%" + boardname + "%'");
    }

    public static List<List<Object>> getMySubsidies(int userId) {
        return queryView("SELECT * FROM MySubsidies WHERE farmerId = " + userId);
    }

// Helper method to query views and return data
    private static List<List<Object>> queryView(String sql) {
        List<List<Object>> data = new ArrayList<>();
        try (Statement stmt = DatabaseConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    // General method to execute query and fetch data
    private static List<List<Object>> fetchData(String query) {
        List<List<Object>> data = new ArrayList<>();
        try (Statement stmt = DatabaseConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static int getCount(String query) {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int getCountWithParam(String query, String param) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, param);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
