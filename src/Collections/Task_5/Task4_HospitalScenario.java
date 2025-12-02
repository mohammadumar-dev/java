package Collections.Task_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task4_HospitalScenario {
    public static void main(String[] args) {

        // Creating a Fail-Fast list (Normal ArrayList)
        List<String> doctorList = new ArrayList<>();
        doctorList.add("Dr. A");
        doctorList.add("Dr. B");

        // Creating a Fail-Safe list (CopyOnWriteArrayList)
        CopyOnWriteArrayList<String> liveDoctorList = new CopyOnWriteArrayList<>();
        liveDoctorList.add("Dr. X");
        liveDoctorList.add("Dr. Y");

        System.out.println("---- Fail-Fast Doctor List ----");
        try {
            // Looping through the ArrayList → Fail-Fast behavior
            for (String d : doctorList) {
                System.out.println("Processing: " + d);

                // Modifying list during iteration → causes ConcurrentModificationException
                doctorList.add("Dr. C");
            }
        } catch (Exception e) {
            // Displaying the fail-fast exception
            System.out.println("Exception: " + e);
        }

        System.out.println("\n---- Fail-Safe Doctor List ----");

        // Looping through CopyOnWriteArrayList → Fail-Safe behavior
        for (String d : liveDoctorList) {
            System.out.println("Processing: " + d);

            // Safe modification during iteration → Does NOT throw any error
            liveDoctorList.add("Dr. Z");
        }

        // Shows the updated list after adding new doctors
        System.out.println("Final Live Doctor List: " + liveDoctorList);
    }
}
