package JDBC.Task_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String args[]) {

        String MAIN_DB = "internship_task1";

        String DEFAULT_URL = "jdbc:postgresql://localhost:5432/postgres"; // default DB
        String USERNAME = "postgres";
        String PASSWORD = "12345";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            // STEP 1 — Connect to default database ("postgres")
            conn = DriverManager.getConnection(DEFAULT_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            System.out.println("Connected to default PostgreSQL database!");

            // STEP 2 — Create your new database (if not exists)
            String createDBSQL = "CREATE DATABASE " + MAIN_DB;
            try {
                stmt.executeUpdate(createDBSQL);
                System.out.println("Database '" + MAIN_DB + "' created successfully!");
            } catch (SQLException e) {
                System.out.println("Database already exists. Skipping creation...");
            }

            // Close connection to default DB
            stmt.close();
            conn.close();

            // STEP 3 — Connect to the NEW database
            String NEW_DB_URL = "jdbc:postgresql://localhost:5432/" + MAIN_DB;
            conn = DriverManager.getConnection(NEW_DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            System.out.println("Connected to '" + MAIN_DB + "' database!");

            // STEP 4 — Create table
            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS departments (" +
                            "department_id SERIAL PRIMARY KEY, " +
                            "department_name VARCHAR(100) UNIQUE" +
                            ")";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'departments' created.");

            // STEP 5 — Insert sample rows
            stmt.executeUpdate("INSERT INTO departments (department_name) VALUES ('Artificial Intelligence')");
            stmt.executeUpdate("INSERT INTO departments (department_name) VALUES ('Cyber Security')");
            stmt.executeUpdate("INSERT INTO departments (department_name) VALUES ('Data Science')");
            System.out.println("Sample departments inserted.");

            // STEP 6 — SELECT and print results
            ResultSet rs = stmt.executeQuery("SELECT * FROM departments");

            System.out.println("\n--- Department List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("department_id") +
                        ", Name: " + rs.getString("department_name"));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Something failed!");
            e.printStackTrace();

        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}

            System.out.println("All database resources closed.");
        }
    }
}
