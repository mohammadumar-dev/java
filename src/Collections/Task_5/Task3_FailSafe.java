package Collections.Task_5;

import java.util.concurrent.CopyOnWriteArrayList;

public class Task3_FailSafe {
    public static void main(String[] args) {

        // Creating a CopyOnWriteArrayList (Fail-Safe collection)
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>();

        numbers.add(1);   // Adding elements
        numbers.add(2);

        // Enhanced for-loop automatically uses a Fail-Safe iterator
        for (Integer n : numbers) {
            System.out.println("Reading: " + n);

            // his will NOT throw any error
            // Because CopyOnWriteArrayList creates a separate copy while iterating
            numbers.add(3);
        }

        // Printing the updated list
        System.out.println("Final List: " + numbers);
    }
}
