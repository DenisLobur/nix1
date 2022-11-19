package lesson13;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static List<Integer> multiplyOddNumbers(@NonNull List<Integer> numbers) {
        List<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 != 0) {
                resultList.add(number * 2);
            }
        }

        return resultList;
    }
}
