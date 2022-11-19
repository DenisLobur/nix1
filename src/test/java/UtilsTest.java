import lesson13.NumberUtils;
import lesson13.WordUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UtilsTest {
    private final List<String> words = List.of("Brown", "fox", "jumps", "over", "the", "lazy", "dog");
    private final List<String> emptyList = List.of();
    private final List<String> sentence = List.of("Banana", "Banana", "Apple", "Orange", "Apple", "Banana");
    private final List<Integer> numbers = List.of(10, 20, 30, 40);
    private final List<Integer> someOddNumbers = List.of(1, 2, 3, 4, 5);

    @Test
    void checkShortestWord() {
        assertEquals("fox", WordUtils.getShortestWord(words));
        assertEquals("", WordUtils.getShortestWord(emptyList));
    }

    @Test
    void checkEntries() {
        Map<String, Integer> entries = WordUtils.calculateEntries(sentence);
        int bananas = 3;
        int apples = 2;
        int oranges = 1;
        assertEquals(entries.get("Banana"), bananas);
        assertEquals(entries.get("Apple"), apples);
        assertEquals(entries.get("Orange"), oranges);
    }

    @Test
    void checkSum() {
        int expected = 100;
        assertEquals(expected, NumberUtils.getSum(numbers));
    }

    @Test
    void checkOddMultiplier() {
        List<Integer> expectedList = List.of(2, 6, 10);
        assertThat(expectedList.equals(NumberUtils.multiplyOddNumbers(someOddNumbers))).isTrue();
    }
}
