package agripro;

import agripro.backend.create.CreateTables;
import agripro.frontend.WelcomePage;

/**
 *
 * @author murei
 */
public class AgriPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WelcomePage WelcomeFrame = new WelcomePage();
        WelcomeFrame.setVisible(true);
        WelcomeFrame.pack();
        WelcomeFrame.setLocationRelativeTo(null);

        // Initialize the database tables and views
        CreateTables.initializeDatabase();

        // Start your app or load your application context here
        System.out.println("Application started, and tables are set up.");

    }

}
