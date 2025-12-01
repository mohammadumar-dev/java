package Collections.Task_3;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeDirectory {
    public static void main(String[] args) {

        TreeMap<Integer, String> employees = new TreeMap<>();

        // Insert employees (unsorted input)
        employees.put(3005, "Rohit");
        employees.put(1002, "Priya");
        employees.put(4001, "Amit");
        employees.put(2003, "Sneha");
        employees.put(1500, "Kunal");

        // Print automatically-sorted employee directory
        System.out.println("--- Sorted Employee Directory ---");
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

