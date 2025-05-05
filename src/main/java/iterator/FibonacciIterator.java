package iterator;

import java.util.Iterator;


public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int curr = 1;
    private int count = 0;
    private final int limit;


    public FibonacciIterator() {
        this.limit = -1;
    }


    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return limit < 0 || count < limit;
    }

    @Override
    public Integer next() {
        int nextValue = curr;
        int newCurr = prev + curr;
        prev = curr;
        curr = newCurr;
        count++;
        return nextValue;
    }
}