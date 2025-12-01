package Collections.Task_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueIPAddresses {
    public static void main(String[] args) {

        // Step 1: Create a List with IP addresses (including duplicates)
        List<String> ipAddresses = new ArrayList<>();

        ipAddresses.add("192.168.1.1");
        ipAddresses.add("10.0.0.5");
        ipAddresses.add("192.168.1.2");
        ipAddresses.add("172.16.0.1");
        ipAddresses.add("10.0.0.5");      // duplicate
        ipAddresses.add("192.168.1.3");
        ipAddresses.add("192.168.1.1");   // duplicate
        ipAddresses.add("172.16.0.1");    // duplicate
        ipAddresses.add("192.168.1.4");
        ipAddresses.add("192.168.1.5");

        // Step 2: Display all IPs (with duplicates)
        System.out.println("Original IP List:");
        for (String ip : ipAddresses) {
            System.out.println(ip);
        }

        // Step 3: Remove duplicates using HashSet
        Set<String> uniqueIPs = new HashSet<>(ipAddresses);

        // Step 4: Display unique IPs
        System.out.println("\nUnique IP Addresses (After Removing Duplicates):");
        for (String ip : uniqueIPs) {
            System.out.println(ip);
        }
    }
}
