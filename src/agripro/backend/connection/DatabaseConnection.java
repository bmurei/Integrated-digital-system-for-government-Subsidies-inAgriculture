/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agripro.backend.connection;

/**
 *
 * @author angera
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:userData.sql";
    private static Connection conn = null;

    // Singleton pattern to get a single instance of the connection
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL);
//                System.out.println("Connection to SQLite has been established.");

                // Add shutdown hook to close the connection when the application exits
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    closeConnection();
                }));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
