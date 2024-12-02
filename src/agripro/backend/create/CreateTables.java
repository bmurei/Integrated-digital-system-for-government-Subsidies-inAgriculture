package agripro.backend.create;

import agripro.backend.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for creating tables and views related to the agriPro application.
 */
public class CreateTables {

    // Shared database connection
    private static final Connection conn = DatabaseConnection.getConnection();

    // Method to create tables and views
    public static void initializeDatabase() {
        createUsersTable();
        createFarmersTable();
        createAvailableSubsidiesTable();
        createSubsidyApplicationTable();
        createFarmerSubsidyDetailsView();
        createDisbursementsTable();
        createInputSupplierTable();
        createNotificationTable();

        // Call view creation methods
        createFarmerSubsidyDetailsView();
        createRegisteredFarmersView();
        createAdvertisedSubsidiesView();
        createApprovedApplicationsView();
        createDeclinedApplicationsView();
        createDisbursementsView();
        createAppliedFarmersView();        // New AppliedFarmers view
        createMySubsidiesView();
    }

    // Method to create the 'users' table
    private static void createUsersTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL,
                phone TEXT NOT NULL,
                regDate DATE NOT NULL DEFAULT CURRENT_DATE,
                password TEXT NOT NULL DEFAULT 'password123',
                userRole TEXT NOT NULL DEFAULT 'guest'
            );
            """;
        executeUpdate(sql, "Users");
    }

    // Method to create the 'farmers' table
    private static void createFarmersTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS farmers (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                userId INTEGER NOT NULL UNIQUE,
                idNumber TEXT NOT NULL UNIQUE,
                address TEXT NOT NULL,
                subCounty TEXT NOT NULL,
                location TEXT NOT NULL,
                village TEXT NOT NULL,
                plotNumber TEXT NOT NULL,
                FOREIGN KEY(userId) REFERENCES users(id) ON DELETE CASCADE
            );
            """;
        executeUpdate(sql, "Farmers");
    }

    // Method to create the 'inputSuppliers' table
    private static void createInputSupplierTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS inputSuppliers (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                userId INTEGER NOT NULL UNIQUE,
                idNumber TEXT NOT NULL UNIQUE,
                serialboardName TEXT NOT NULL,
                serialboardLocation TEXT NOT NULL,
                FOREIGN KEY(userId) REFERENCES users(id) ON DELETE CASCADE
            );
            """;
        executeUpdate(sql, "inputSuppliers");
    }

    // Method to create the 'availableSubsidies' table
    private static void createAvailableSubsidiesTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS availableSubsidies (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                subsidyCategory TEXT NOT NULL,
                subsidyType TEXT NOT NULL,
                openingDate DATE NOT NULL DEFAULT CURRENT_DATE,
                subsidyStatus TEXT NOT NULL DEFAULT 'open',
                dueDate DATE NOT NULL DEFAULT (DATE(CURRENT_DATE, '+3 MONTHS')),
                amountPerUnit DECIMAL(10,2) DEFAULT 0.00, 
                quantity TEXT NOT NULL DEFAULT '0.0'
            );
            """;
        executeUpdate(sql, "AvailableSubsidies");
    }

    // Method to create the 'subsidyApplication' table
    private static void createSubsidyApplicationTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS subsidyApplication (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                farmerId INTEGER NOT NULL,
                subsidyId INTEGER NOT NULL,
                serialNo TEXT NOT NULL UNIQUE,
                sizeOfFarm TEXT NOT NULL DEFAULT 'N/A',
                nearestSerialBoards TEXT NOT NULL,
                applicationType TEXT NOT NULL DEFAULT 'First time',
                quantity TEXT NOT NULL,
                applicationDate DATE NOT NULL DEFAULT CURRENT_DATE,
                status TEXT NOT NULL DEFAULT 'Reviewing',
                comments TEXT NOT NULL DEFAULT 'No Comment',
                amountBilled DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
                amountPaid DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
                balance DECIMAL(15, 2) AS (amountBilled - amountPaid),
                FOREIGN KEY(farmerId) REFERENCES farmers(id) ON DELETE CASCADE,
                FOREIGN KEY(subsidyId) REFERENCES availableSubsidies(id) ON DELETE CASCADE
            );
            """;
        executeUpdate(sql, "SubsidyApplication");
    }

    // Method to create the 'disbursedSubsidy' table
    private static void createDisbursementsTable() {
        // SQL query to create the table
        String sql = """
            CREATE TABLE IF NOT EXISTS disbursedSubsidy (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                serialNo TEXT NOT NULL UNIQUE,
                amountPaid REAL,
                comments TEXT,
                serialBoards TEXT,
                FOREIGN KEY(serialNo) REFERENCES subsidyApplication(serialNo) ON DELETE CASCADE ON UPDATE CASCADE
            );
        """;
        executeUpdate(sql, "disbursedSubsidy");
    }

    // Method to create the 'notifications' table
    private static void createNotificationTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS notifications (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                toRole TEXT NOT NULL,
                specificId TEXT NOT NULL DEFAULT 'N/A',
                messageTitle TEXT NOT NULL,
                messageBody TEXT NOT NULL,
                datePosted DATE NOT NULL DEFAULT CURRENT_DATE,
                status TEXT NOT NULL DEFAULT 'unread',
                FOREIGN KEY(specificId) REFERENCES users(id) ON DELETE CASCADE
            );
            """;
        executeUpdate(sql, "notifications");
    }

    /*
    VIEWS FOR EASY RETRIEVAL OF DATA.
     */
    // Method to create the 'FarmerSubsidyDetails' view
    private static void createFarmerSubsidyDetailsView() {
        String sql = """
            CREATE VIEW IF NOT EXISTS FarmerSubsidyDetails AS
            SELECT 
                f.id AS farmerId,
                u.name AS farmerName,
                u.phone AS farmerPhone,
                u.email AS farmerEmail,
                f.subCounty AS farmerSubCounty,
                f.village AS farmerVillage,
                sa.nearestSerialBoards AS serialBoards,
                sa.serialNo,
                sa.amountBilled,
                sa.amountPaid,
                sa.applicationType,
                sa.applicationDate,
                sa.status
            FROM 
                farmers f
            JOIN 
                users u ON f.userId = u.id
            JOIN 
                subsidyApplication sa ON f.id = sa.farmerId;
            """;
        executeUpdate(sql, "FarmerSubsidyDetails View");
    }

    // Helper method to execute SQL statements and print the status
    private static void executeUpdate(String sql, String tableName) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(tableName + " created or already exists.");
        } catch (SQLException e) {
            System.out.println("Failed to create " + tableName + ".");
            e.printStackTrace();
        }
    }

    // Method to create the 'RegisteredFarmers' view
    private static void createRegisteredFarmersView() {
        String sql = """
    CREATE VIEW IF NOT EXISTS RegisteredFarmers AS
    SELECT f.id AS farmerId, u.name AS farmerName, f.subCounty, f.location, f.village, 
           asd.subsidyCategory, sa.amountBilled
    FROM farmers f
    JOIN users u ON f.userId = u.id
    JOIN subsidyApplication sa ON f.id = sa.farmerId
    JOIN availableSubsidies asd ON sa.subsidyId = asd.id;
    """;
        executeUpdate(sql, "RegisteredFarmers View");
    }

// Method to create the 'AdvertisedSubsidies' view
    // Method to create the 'AdvertisedSubsidies' view
    private static void createAdvertisedSubsidiesView() {
        String sql = """
        CREATE VIEW IF NOT EXISTS AdvertisedSubsidies AS
        SELECT 
            asd.id AS subsidyId,
            asd.subsidyCategory,
            asd.subsidyType,
            asd.openingDate,
            asd.dueDate,
            asd.amountPerUnit,
            COUNT(sa.id) AS farmersApplied,
            SUM(CASE WHEN sa.status IN ('Approved', 'Disbursement In Progress', 'Disbursed') 
                        THEN 1 
                        ELSE 0 
                    END)  AS farmersApproved,
            SUM(CASE WHEN sa.status = 'Declined' THEN 1 ELSE 0 END) AS farmersDeclined
        FROM 
            availableSubsidies asd
        LEFT JOIN 
            subsidyApplication sa ON asd.id = sa.subsidyId
        GROUP BY 
            asd.id, asd.subsidyCategory, asd.subsidyType, asd.openingDate, asd.dueDate, asd.amountPerUnit;
        """;
        executeUpdate(sql, "AdvertisedSubsidies View");
    }

// Method to create the 'ApprovedApplications' view
    private static void createApprovedApplicationsView() {
        String sql = """
        CREATE VIEW IF NOT EXISTS ApprovedApplications AS
        SELECT 
                    f.id AS farmerId,
                    sa.serialNo,
                    u.name AS farmerName,
                    sa.nearestSerialBoards,
                    asd.subsidyCategory,
                    asd.subsidyType,
                    sa.amountBilled,
                    sa.comments,
                    sa.status
                FROM 
                    subsidyApplication sa
                JOIN 
                    farmers f ON sa.farmerId = f.id
                JOIN 
                    users u ON f.userId = u.id
                JOIN 
                    availableSubsidies asd ON sa.subsidyId = asd.id 
                WHERE 
                    sa.status = 'Approved' 
                OR sa.status = 'Disbursement In Progress' 
                OR sa.status = 'Disbursed';
    """;
        executeUpdate(sql, "ApprovedApplications View");
    }

// Method to create the 'DeclinedApplications' view
    private static void createDeclinedApplicationsView() {
        String sql = """
        CREATE VIEW IF NOT EXISTS DeclinedApplications AS
        SELECT 
                           f.id AS farmerId,
                           sa.serialNo,
                           u.name AS farmerName,
                           sa.nearestSerialBoards,
                           asd.subsidyCategory,
                           asd.subsidyType,
                           sa.amountBilled,
                           sa.comments,
                           sa.status
                       FROM 
                           subsidyApplication sa
                       JOIN 
                           farmers f ON sa.farmerId = f.id
                       JOIN 
                           users u ON f.userId = u.id
                       JOIN 
                           availableSubsidies asd ON sa.subsidyId = asd.id 
        WHERE 
            sa.status = 'Declined';
    """;
        executeUpdate(sql, "DeclinedApplications View");
    }

// Method to create the 'Disbursements' view
    private static void createDisbursementsView() {
        String sql = """
        CREATE VIEW IF NOT EXISTS Disbursements AS
        SELECT 
            f.id AS farmerId,
            sa.serialNo,
            u.name AS farmerName,
            f.subCounty,
            ds.serialBoards,
            asd.subsidyCategory,
            asd.subsidyType,
            ds.amountPaid,
            ds.id AS disbursementId
        FROM 
            disbursedSubsidy ds
        JOIN 
            subsidyApplication sa ON ds.serialNo = sa.serialNo
        JOIN 
            farmers f ON sa.farmerId = f.id
        JOIN 
            users u ON f.userId = u.id
        JOIN 
            availableSubsidies asd ON sa.subsidyId = asd.id;
    """;
        executeUpdate(sql, "Disbursements View");
    }

    // Method to create the 'AppliedFarmers' view
    private static void createAppliedFarmersView() {
        String sql = """
    CREATE VIEW IF NOT EXISTS AppliedFarmers AS
    SELECT 
        f.id AS farmerId,
        sa.serialNo,
        u.name AS farmerName,
        f.subCounty,
        f.village,
        sa.sizeOfFarm,
        sa.nearestSerialBoards,
        asb.subsidyCategory,
        asb.subsidyType,
        sa.quantity,
        sa.amountBilled,
        sa.applicationDate,
        sa.status
    FROM 
        subsidyApplication sa
    JOIN 
        farmers f ON sa.farmerId = f.id
    JOIN 
        users u ON f.userId = u.id
    JOIN 
        availableSubsidies asb ON sa.subsidyId = asb.id;
    """;
        executeUpdate(sql, "AppliedFarmers View");
    }

// Method to create the 'MySubsidies' view
    private static void createMySubsidiesView() {
        String sql = """
    CREATE VIEW IF NOT EXISTS MySubsidies AS
    SELECT 
        sa.serialNo,
        u.name AS farmerName,
        sa.nearestSerialBoards AS serialBoards,
        asd.subsidyCategory,
        asd.subsidyType,
        sa.amountBilled,
        sa.status,
        f.id AS farmerId
    FROM subsidyApplication sa
    JOIN farmers f ON sa.farmerId = f.id
    JOIN users u ON f.userId = u.id
    JOIN availableSubsidies asd ON sa.subsidyId = asd.id
    WHERE sa.farmerId = f.id;
    """;
        executeUpdate(sql, "MySubsidies View");
    }

}
