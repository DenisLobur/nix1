package lesson11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AlgorithmsTest {

    private final int[] initialArr = {5, 4, 3, 2, 1};
    private final int[] sortedArray = {10, 20, 30, 40, 50};

    @Test
    void checkBubbleSort() {
        int[] expectedArray = {1, 2, 3, 4, 5};
        int[] afterSort = Algorithms.bubbleSort(initialArr);
        for (int i = 0; i < initialArr.length; i++) {
            assertEquals(afterSort[i], expectedArray[i]);
        }
    }

    @Test
    void checkBinarySearch() {
        int expectedValue = 40;
        int expectedIndex = 3;
        int left = 0;
        int right = initialArr.length - 1;
        int foundIndex = Algorithms.binarySearch(sortedArray, left, right, expectedValue);
        assertEquals(expectedIndex, foundIndex);
    }
}
