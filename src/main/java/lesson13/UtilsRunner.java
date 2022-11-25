package lesson13;

import java.util.Collections;
import java.util.List;

public class UtilsRunner {
    public static void main(String[] args) {
        List<String> words = List.of("Brown", "fox", "jumps", "over", "the", "lazy", "dog");
        List<String> empty = Collections.emptyList();
        List<String> nullList = null;
        System.out.println(WordUtils.getShortestWord(words));

        List<String> sentence = List.of("Banana", "Banana", "Apple", "Orange", "Apple", "Banana");
        System.out.println(WordUtils.calculateEntries(sentence));

        List<Integer> numbers = List.of(10, 20, 30, 40);
        System.out.println(NumberUtils.getSum(numbers));

        List<Integer> someOddNumbers = List.of(1, 2, 3, 4, 5);
        System.out.println(NumberUtils.multiplyOddNumbers(someOddNumbers));

    }
}
