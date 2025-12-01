package Collections.Task_2;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CityNamesOrder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LinkedHashSet keeps order + removes duplicates
        Set<String> cities = new LinkedHashSet<>();

        System.out.println("Enter 5 city names:");

        for (int i = 0; i < 5; i++) {
            String city = sc.nextLine();
            cities.add(city);  // duplicate will be ignored
        }

        // Displaying cities in entered order without duplicates
        System.out.println("\nCities (Without Duplicates, in Same Order):");
        for (String c : cities) {
            System.out.println(c);
        }

        sc.close();
    }
}

