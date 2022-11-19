package lesson12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionalStackTest {

    private final ExceptionalStack emptyStack = new ExceptionalStack(0);
    private final ExceptionalStack notEmptyStack = new ExceptionalStack(1);

    @BeforeAll
    void initStack() throws StackFullException {
        notEmptyStack.push(1);
    }

    @Test
    void checkOptionalPop() {
        Optional<Integer> emptyOptional = emptyStack.popIfPresent();
        Optional<Integer> notEmptyOptional = notEmptyStack.popIfPresent();
        int expectedValueEmpty = emptyOptional.orElse(-1);
        int expectedValueNonEmpty = notEmptyOptional.orElse(-1);

        assertTrue(emptyOptional.isEmpty());
        assertTrue(notEmptyOptional.isPresent());
        assertEquals(expectedValueNonEmpty, 1);
        assertEquals(expectedValueEmpty, -1);
    }

    @Test
    void checkIfStackEmptyIsThrown() {
        assertThatExceptionOfType(StackEmptyException.class)
                .isThrownBy(emptyStack::pop).withMessage("Trying to pop on empty stack");
    }

    @Test
    void checkIfStackFullIsThrown() {
        assertThatExceptionOfType(StackFullException.class)
                .isThrownBy(() -> {
                    emptyStack.push(1);
                }).withMessage("Trying to push into full stack");
    }
}
