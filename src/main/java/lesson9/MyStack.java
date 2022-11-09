package lesson9;

import java.util.NoSuchElementException;

public class MyStack implements Stackable {

    private final int capacity;
    private final int[] array;
    private int top;

    public MyStack(int capacity) {
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
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full. Can not add more elements");
            throw new IllegalStateException("Trying to push into full stack");
        }
        System.out.printf("Adding %s to stack\n", element);
        array[++top] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Can not pop an element");
            throw new NoSuchElementException("Trying to pop on empty stack");
        }

        System.out.printf("Removing %s from stack\n", peek());
        return array[top--];
    }

    @Override
    public int peek() {
        if (!isEmpty()) {
            return array[top];
        } else {
            throw new NoSuchElementException("Trying to peek on empty stack");
        }
    }

    // For testing purposes
    public int size() {
        return top + 1;
    }
}
