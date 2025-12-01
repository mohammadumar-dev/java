package Collections.Task_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapCollectionTask {
    public static void main(String[] args) {

        // Creating a HashMap to store key-value pairs
        Map<String, String> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter a number of inputs");
//        int n = sc.nextInt();

        System.out.println("----- Add 5 Words with Their Meanings -----");

        // Taking 5 inputs from the user and storing them in the map
        for (int i = 0; i < 2; i++) {

            System.out.print("Enter a Key (word): ");
            String key = sc.nextLine();

            System.out.print("Enter a Value (meaning): ");
            String value = sc.nextLine();

            // Storing user input in the map
            map.put(key, value);
        }

        /*
        map.put("Happy", "Feeling good");
        map.put("Fast", "Moving quickly");
        map.put("Cold", "Low temperature");
        map.put("Big", "Large in size");
        map.put("Small", "Little in size");
        */

        System.out.println("\n----- Search a Word -----");

        System.out.print("Enter a word to search: ");
        String word = sc.nextLine();

        // containsKey() checks if the key exists in the map
        if (map.containsKey(word)) {
            // get() returns the value for the given key
            System.out.println("Meaning: " + map.get(word));
        } else {
            System.out.println("Word not found!");
        }

        System.out.println("\n----- Displaying Map Data -----");

        // entrySet() → returns all key-value pairs in the map
        System.out.println("All Entries (key=value): " + map.entrySet());

        // keySet() → returns only keys
        System.out.println("All Keys: " + map.keySet());

        // values() → returns only values
        System.out.println("All Values: " + map.values());

        // returns all in random orders
        System.out.println(map);

        sc.close();
    }
}
