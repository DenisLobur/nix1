package lesson14.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    protected final int start;
    protected final int end;
    protected final int[] data;
    protected final int size;
    protected Direction direction;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;

        if (start > end) {
            direction = Direction.DECREASE;
        } else {
            direction = Direction.INCREASE;
        }

        this.size = switch (direction) {
            case INCREASE -> end - start;
            case DECREASE -> start - end;
        };
        data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = switch (direction) {
                case INCREASE -> start + i;
                case DECREASE -> start - i;
            };
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < Range.this.data.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in this Range");
            }
            return data[current++];
        }
    }
}
