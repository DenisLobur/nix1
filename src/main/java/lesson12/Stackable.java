package lesson12;

import java.util.Optional;

public interface Stackable {

    boolean isEmpty();

    boolean isFull();

    void push(int element) throws StackFullException;

    int pop()  throws StackEmptyException;

    Optional<Integer> popIfPresent();

    int peek() throws StackEmptyException;

    int size();
}
