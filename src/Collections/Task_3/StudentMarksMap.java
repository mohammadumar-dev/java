package Collections.Task_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMarksMap {

    public static void main(String[] args) {

        // HashMap to store RollNo (Integer) -> Marks (Integer)
        Map<Integer, Integer> studentMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number of inputs");
        int n = sc.nextInt();

        System.out.println("----- Add Student Marks -----");

        // Add 5 students
        for (int i = 0; i < n; i++) {

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            studentMap.put(roll, marks);
        }

        // -------------------------
        // Update Marks
        // -------------------------
        System.out.println("\n----- Update Student Marks -----");
        System.out.print("Enter roll number to update marks: ");
        int updateRoll = sc.nextInt();

        if (studentMap.containsKey(updateRoll)) {
            System.out.print("Enter new marks: ");
            int newMarks = sc.nextInt();
            studentMap.put(updateRoll, newMarks); // update
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Roll number not found!");
        }

        // -------------------------
        // Search Roll Number
        // -------------------------
        System.out.println("\n----- Search Student -----");
        System.out.print("Enter roll number to search: ");
        int searchRoll = sc.nextInt();

        if (studentMap.containsKey(searchRoll)) {
            System.out.println("Marks: " + studentMap.get(searchRoll));
        } else {
            System.out.println("Roll number not found!");
        }

        // -------------------------
        // Print complete HashMap
        // -------------------------
        System.out.println("\n----- Full HashMap (Order is Random) -----");
        System.out.println(studentMap);

        sc.close();
    }
}
