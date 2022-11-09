package lesson9;

public interface Stackable {

    boolean isEmpty();

    boolean isFull();

    void push(int element);

    int pop();

    int peek();

    int size();
}
