package Collections.Task_2;

import java.util.Set;
import java.util.TreeSet;

public class SortedProductPrices {
    public static void main(String[] args) {

        // TreeSet stores values in sorted order
        Set<Double> productPrices = new TreeSet<>();

        // Adding product prices (unsorted + duplicates)
        productPrices.add(499.99);
        productPrices.add(299.49);
        productPrices.add(999.00);
        productPrices.add(799.50);
        productPrices.add(299.49); // duplicate
        productPrices.add(149.99);

        // Displaying sorted prices
        System.out.println("Sorted Product Prices:");
        for (Double price : productPrices) {
            System.out.println(price);
        }
    }
}

