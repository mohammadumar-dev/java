package Collections.Task_3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceSystem {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> attendance = new LinkedHashMap<>();

        // Inserting students in the order they enter
        addStudent(attendance, 101, "Aman");
        addStudent(attendance, 102, "Riya");
        addStudent(attendance, 103, "Karan");
        addStudent(attendance, 104, "Simran");
        addStudent(attendance, 105, "Aarav");

        // Trying to add duplicate roll number
        addStudent(attendance, 103, "Duplicate");

        // Print attendance list
        System.out.println("\n--- Attendance List (Order of Arrival) ---");
        for (Map.Entry<Integer, String> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Search by roll number
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter roll number to search: ");
        int roll = sc.nextInt();

        if (attendance.containsKey(roll)) {
            System.out.println("Student Found: " + attendance.get(roll));
        } else {
            System.out.println("Roll number not found!");
        }
    }

    // Method to avoid duplicate roll numbers
    static void addStudent(LinkedHashMap<Integer, String> map, int roll, String name) {
        if (map.containsKey(roll)) {
            System.out.println("Duplicate roll number ignored: " + roll);
        } else {
            map.put(roll, name);
        }
    }
}

