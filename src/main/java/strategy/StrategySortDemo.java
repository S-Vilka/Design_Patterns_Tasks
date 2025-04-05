package strategy;

import java.util.Random;

public class StrategySortDemo {

    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100_000);

        testSortingStrategy("Arrays.sort()", new ArraySortStrategy(), smallArray, largeArray);
        testSortingStrategy("Collections.sort()", new CollcetionsSortStrategy(), smallArray, largeArray);
        testSortingStrategy("Custom Comparator (Descending)", new CustomComparatorSortStrategy(), smallArray, largeArray);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt(10_000);
        return array;
    }

    private static void testSortingStrategy(String name, SortStrategy strategy, int[] small, int[] large) {
        SortContext context = new SortContext(strategy);

        int[] smallCopy = small.clone();
        int[] largeCopy = large.clone();

        System.out.println("\n=== " + name + " ===");

        long start = System.nanoTime();
        context.executeSort(smallCopy);
        long end = System.nanoTime();
        System.out.println("Small array time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        context.executeSort(largeCopy);
        end = System.nanoTime();
        System.out.println("Large array time: " + (end - start) / 1_000_000.0 + " ms");
    }
}

// Sorting strategy methods are taken from https://www.geeksforgeeks.org/sorting-algorithms/