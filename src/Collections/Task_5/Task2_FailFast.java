package Collections.Task_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2_FailFast {
    public static void main(String[] args) {

        // Create an ArrayList and add some elements
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Create an iterator for the list
        Iterator<String> itr = list.iterator();

        // Loop through the list using iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());  // Print current element

            // Changing the list while iterating → causes Fail-Fast error
            list.add("New");  // This will throw ConcurrentModificationException
        }
    }
}
