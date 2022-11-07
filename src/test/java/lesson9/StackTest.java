package lesson9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class StackTest {
    private Stackable emptyStack = new MyStack(0);
    private Stackable oneElementStack = new MyStack(1);
    private Stackable fewElementsStack = new MyStack(5);

    @Test
    void checkIfFull() {
        oneElementStack.push(10);
        assertThat(oneElementStack.size()).isEqualTo(1);
    }

    @Test
    void checkIfEmpty() {
        assertThat(emptyStack.size()).isEqualTo(0);
        oneElementStack.push(1);
        assertThat(oneElementStack.size()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkPush(int input) {
        fewElementsStack.push(input);
        int topmostValue = fewElementsStack.peek();
        assertEquals(input, topmostValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkPop(int input) {
        fewElementsStack.push(input);
        int poppedElement = fewElementsStack.pop();
        assertThat(poppedElement).isEqualTo(input);
    }

    @Test
    void checkPeek() {
        fewElementsStack.push(1);
        fewElementsStack.push(2);
        int peekElement = fewElementsStack.peek();
        assertThat(peekElement).isEqualTo(2);
        assertThat(fewElementsStack.size()).isEqualTo(2);
    }
}
