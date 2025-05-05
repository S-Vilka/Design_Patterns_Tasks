package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new FibonacciSequence();

        // Example 1: first 10 Fibonacci numbers
        System.out.println("First 10 Fibonacci numbers:");
        Iterator<Integer> iterator = new FibonacciIterator(10);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Example 2: unbounded sequence (stopped after 15 numbers)
        System.out.println("\n\nFirst 15 Fibonacci numbers from unbounded sequence:");
        Iterator<Integer> infiniteIterator = sequence.iterator();
        for (int i = 0; i < 15 && infiniteIterator.hasNext(); i++) {
            System.out.print(infiniteIterator.next() + " ");
        }
    }
}