package lesson14.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeWithStep extends Range implements Iterable<Integer> {
    private final int step;

    public RangeWithStep(int start, int end, int step) {
        super(start, end);
        if (step < 0) throw new IllegalArgumentException("Step must be a positive value");
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIteratorWithStep();
    }

    private class RangeIteratorWithStep implements Iterator<Integer> {

        int current = -step;

        @Override
        public boolean hasNext() {
            return (current + step) < RangeWithStep.this.data.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in this Range");
            }
            current = current + step;
            return data[current];
        }
    }
}
