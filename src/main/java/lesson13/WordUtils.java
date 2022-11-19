package lesson13;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordUtils {

    public static String getShortestWord(@NonNull List<String> words) {
        String shortestWord = "";
        if (words.isEmpty())
            return shortestWord;

        shortestWord = words.get(0);
        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        return shortestWord;
    }

    public static Map<String, Integer> calculateEntries(@NonNull List<String> sentence) {
        Map<String, Integer> entriesMap = new HashMap<>();
        int counter;
        for (String word : sentence) {
            if (!entriesMap.containsKey(word)) {
                counter = 1;
            } else {
                counter = entriesMap.get(word) + 1;
            }
            entriesMap.put(word, counter);
        }

        return entriesMap;
    }
}
