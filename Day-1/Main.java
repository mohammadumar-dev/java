import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String args[]) {

        String URL = "jdbc:postgresql://localhost:5432/internship_day1";
        String USERNAME = "postgres";
        String PASSWORD = "12345";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Create connection
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");

            // Create statement
            stmt = conn.createStatement();

            // INSERT DATA
            String insertSQL = "INSERT INTO departments (department_name) VALUES ('Artificial intelligence')";
            int rowsInserted = stmt.executeUpdate(insertSQL);
            System.out.println(rowsInserted + " row inserted.");

            // SELECT DATA
            String selectSQL = "SELECT * FROM departments";
            rs = stmt.executeQuery(selectSQL);

            System.out.println("\n--- Department List ---");
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {

            // Close ResultSet
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Close Statement
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Close Connection
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("All database resources closed.");
        }
    }
}
