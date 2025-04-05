package strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomComparatorSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().toList();
        list = list.stream().sorted(Comparator.reverseOrder()).toList();
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }
}

// Sorting strategy methods are taken from https://www.geeksforgeeks.org/sorting-algorithms/