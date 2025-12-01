package Collections.Task_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {

        // Create a List and store values
        List<String> names = new ArrayList<>();
        names.add("Aman");
        names.add("Neha");
        names.add("Aman");
        names.add("Rohit");
        names.add("Neha");
        names.add("Sahil");
        names.add("Aman");

        // Display the original list (with duplicates)
        System.out.println(names);

        // Remove duplicates using HashSet
        Set<String> uniqueNames = new HashSet<>(names);

        // Display the set with unique values
        System.out.println(uniqueNames);

        // Convert Set back to List
        List<String> uniqueList = new ArrayList<>(uniqueNames);
        System.out.println(uniqueList);

    }
}
