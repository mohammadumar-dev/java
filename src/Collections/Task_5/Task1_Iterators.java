package Collections.Task_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Task1_Iterators {
    public static void main(String[] args) {

        // Create a List and add elements
        List<String> list = new ArrayList<>();

        list.add("Apple");   // index 0
        list.add("Banana");  // index 1
        list.add("Cherry");  // index 2

        // 1. Using Iterator (Forward traversal - one direction)
        System.out.println("Using Iterator:");

        // iterator() returns an Iterator object for the list
        Iterator<String> itr = list.iterator();

        // Loop until the iterator has no more elements
        while (itr.hasNext()) {
            // next() returns the next element in the list
            System.out.println(itr.next());
        }


        // 2. Using Enhanced For-each Loop
        // (Simplest way to iterate; internally uses Iterator)
        System.out.println("\nUsing For-each Loop:");

        for (String item : list) {
            System.out.println(item);
        }


        // 3. Using ListIterator for Reverse Traversal
        // (Iterator for Lists that supports backward movement)
        System.out.println("\nUsing ListIterator (Reverse Traversal):");

        // Start ListIterator at end of list
        // list.size() → logical position AFTER the last element
        ListIterator<String> listItr = list.listIterator(list.size());

        // Move backwards and print elements
        while (listItr.hasPrevious()) {
            // previous() returns the element before the current position
            System.out.println(listItr.previous());
        }
    }
}
