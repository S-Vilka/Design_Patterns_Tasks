package strategy;

import java.util.Arrays;

public class ArraySortStrategy  implements SortStrategy {

    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}

// Sorting strategy methods are taken from https://www.geeksforgeeks.org/sorting-algorithms/