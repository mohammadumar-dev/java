package JDBC.Task_2;

import java.sql.Connection;        // Used to connect to the database
import java.sql.DriverManager;     // Creates the connection using URL, username, password
import java.sql.SQLException;      // Handles SQL errors
import java.sql.Statement;         // Used for simple SQL commands (not used in CRUD)
import java.sql.PreparedStatement; // Used for parameterized SQL queries
import java.sql.ResultSet;         // Stores data from SELECT queries

public class Main {

    // CRUD METHODS
    // Insert a new student into the database
    public static void insertStudent(Connection con, String name, int age) throws Exception {

        String query = "INSERT INTO students(name, age) VALUES(?, ?)"; // SQL insert query
        PreparedStatement ps = con.prepareStatement(query);            // Prepare the query

        ps.setString(1, name); // Set first parameter (name)
        ps.setInt(2, age);     // Set second parameter (age)

        ps.executeUpdate();    // Run the query
        System.out.println("Inserted Successfully: " + name); // Confirmation message
    }

    // Select and print all students from the table
    public static void getAllStudents(Connection con) throws Exception {

        String query = "SELECT * FROM students";          // SQL select query
        PreparedStatement ps = con.prepareStatement(query); // Prepare query

        ResultSet rs = ps.executeQuery();                // Execute SELECT

        System.out.println("\n--- Student List ---");
        while (rs.next()) {                              // Loop through rows
            int id = rs.getInt("id");                    // Get ID column
            String name = rs.getString("name");          // Get name column
            int age = rs.getInt("age");                  // Get age column

            System.out.println(id + " | " + name + " | " + age); // Print student data
        }
        System.out.println("----------------------\n");
    }

    // Update student's name using their ID
    public static void updateStudent(Connection con, int id, String newName) throws Exception {

        String query = "UPDATE students SET name = ? WHERE id = ?"; // SQL update query
        PreparedStatement ps = con.prepareStatement(query);         // Prepare query

        ps.setString(1, newName); // Set new name
        ps.setInt(2, id);         // Set student ID

        int rows = ps.executeUpdate(); // Execute update

        if (rows > 0) // If at least one row updated
            System.out.println("Updated Successfully (ID = " + id + ")");
        else
            System.out.println("No student found with ID: " + id);
    }

    // Delete a student using their ID
    public static void deleteStudent(Connection con, int id) throws Exception {

        String query = "DELETE FROM students WHERE id = ?"; // SQL delete query
        PreparedStatement ps = con.prepareStatement(query); // Prepare query

        ps.setInt(1, id); // Set the ID

        int rows = ps.executeUpdate(); // Execute deletion

        if (rows > 0) // If a row was deleted
            System.out.println("Deleted Successfully (ID = " + id + ")");
        else
            System.out.println("No student found with ID: " + id);
    }

    public static void main(String args[]) {

        String URL = "jdbc:postgresql://localhost:5432/internship_task1"; // Database URL
        String USERNAME = "postgres"; // Database username
        String PASSWORD = "12345";    // Database password

        Connection conn = null; // Will store connection object
        Statement stmt = null;  // Optional (not required for PreparedStatement)

        try {
            Class.forName("org.postgresql.Driver"); // Load PostgreSQL driver

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Connect to DB
            System.out.println("Connected to PostgreSQL database!");

            stmt = conn.createStatement();
            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS students (" +
                            "id SERIAL PRIMARY KEY, " +   // Auto-increment ID
                            "name VARCHAR(50)," +        // Student name
                            "age INT" +                  // Student age
                            ")";

            // Run the CREATE TABLE SQL
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created");

            // Insert 2 students
            insertStudent(conn, "John", 20);
            insertStudent(conn, "Sara", 22);

            // Show all students
            getAllStudents(conn);

            // Update student with ID 1
            updateStudent(conn, 1, "John Updated");

            // Delete student with ID 2
            deleteStudent(conn, 2);

            // Show final list
            getAllStudents(conn);

        } catch (Exception e) {
            System.out.println("Connection failed!"); // Print error message
            e.printStackTrace();                     // Print error details

        } finally {
            // Close resources safely
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}

            System.out.println("All database resources closed.");
        }
    }
}
