package lesson5;

import java.util.Random;

public class PrimeRunner {
    private static int numberToCheck = new Random().nextInt(0, 100);

    public static void main(String[] args) {
        System.out.printf("Is %d prime? %b",  numberToCheck, Prime.isPrime(numberToCheck, 2));
    }
}
