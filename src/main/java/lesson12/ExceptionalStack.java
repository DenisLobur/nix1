package lesson12;

import java.util.Optional;

public class ExceptionalStack implements Stackable {

    private final int capacity;
    private final int[] array;
    private int top;

    public ExceptionalStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public void push(int element) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Trying to push into full stack");
        }
        array[++top] = element;
    }

    @Override
    public int pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Trying to pop on empty stack");
        }

        return array[top--];
    }

    @Override
    public Optional<Integer> popIfPresent() {
        if (isEmpty()) {
            return Optional.empty();
        } else return Optional.of(array[top--]);
    }

    @Override
    public int peek() throws StackEmptyException {
        if (!isEmpty()) {
            return array[top];
        } else {
            throw new StackEmptyException("Trying to peek on empty stack");
        }
    }

    @Override
    public int size() {
        return top + 1;
    }
}
