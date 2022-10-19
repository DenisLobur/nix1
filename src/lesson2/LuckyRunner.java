package lesson2;

import java.util.Random;

public class LuckyRunner {
    public static void main(String[] args) {
        int luckyNumber = new Random().nextInt(1,10);
        System.out.printf("Your lucky number: %d", luckyNumber);
    }
}