package JDBC;

// These imports are required for connecting and working with a database.
import java.sql.Connection;   // Used to connect to the database
import java.sql.DriverManager; // Helps create the connection
import java.sql.SQLException;  // Handles database errors
import java.sql.Statement;     // Used to write/run SQL statements like INSERT, SELECT
import java.sql.ResultSet;     // Stores data returned from SELECT queries

public class Main {
    public static void main(String args[]) {

        // Database details (URL, username, password)
        String URL = "jdbc:postgresql://localhost:5432/internship_task1";
        String USERNAME = "postgres";
        String PASSWORD = "12345";

        // Variables to store database objects
        Connection conn = null;  // Connection link to the database
        Statement stmt = null;   // Used to run SQL commands
        ResultSet rs = null;     // Used to store results from SELECT query

        try {
            // 1. Load PostgreSQL JDBC Driver
            // This allows Java to communicate with the PostgreSQL database.
            Class.forName("org.postgresql.Driver");

            // 2. Create a connection to the database using URL, username, and password
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");

            // 3. Create a Statement object to send SQL commands to the database
            stmt = conn.createStatement();

            // 4. SQL to create the table (only if it does not already exist)
            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS departments (" +
                            "department_id SERIAL PRIMARY KEY, " +   // Auto-increment ID
                            "department_name VARCHAR(100)" + // Name must be unique
                            ")";

            // Run the CREATE TABLE SQL
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'departments' created");

            // 5. Insert sample data into the departments table
            // Each INSERT adds one department name
            String insertSQL1 = "INSERT INTO departments (department_name) VALUES ('Artificial Intelligence')";
            String insertSQL2 = "INSERT INTO departments (department_name) VALUES ('Cyber Security')";
            String insertSQL3 = "INSERT INTO departments (department_name) VALUES ('Data Science')";

            // Run all INSERT queries
            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);

            System.out.println("Sample departments inserted.");

            // 6. Fetch (SELECT) all data from the departments table
            String selectSQL = "SELECT * FROM departments";
            rs = stmt.executeQuery(selectSQL); // Store the result of SELECT in 'rs'

            // 7. Read and print all rows from the ResultSet
            System.out.println("\n--- Department List ---");
            while (rs.next()) {
                int id = rs.getInt("department_id");         // Read the id column
                String name = rs.getString("department_name"); // Read the name column
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (Exception e) {
            // If any error happens, print message + error details
            System.out.println("Connection failed!");
            e.printStackTrace();

        } finally {
            // 8. Close all database resources (very important!)

            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}

            System.out.println("All database resources closed.");
        }
    }
}
