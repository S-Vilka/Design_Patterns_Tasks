package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollcetionsSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] array) {
        List<Integer> list = new ArrayList<>(Arrays.stream(array).boxed().toList());
        Collections.sort(list);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }
}

// Sorting strategy methods are taken from https://www.geeksforgeeks.org/sorting-algorithms/