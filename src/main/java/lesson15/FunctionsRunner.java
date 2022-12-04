package lesson15;

import lesson4.WeekDays;

import java.util.Random;
import java.util.function.*;


public class FunctionsRunner {
    public static void main(String[] args) {
        Predicate<Integer> isPrime = x -> isPrime(x, 2);
        System.out.println("3 is prime? " + isPrime.test(3));

        Consumer<Integer> range = x -> System.out.println(new Random().nextInt(0, x));
        range.accept(5);

        Supplier<WeekDays> day = () -> WeekDays.SUN;
        System.out.println(day.get());

        Function<Double, Long> round = Math::round;
        System.out.println(round.apply(5.5));

        UnaryOperator<Integer> fibb = FunctionsRunner::fib;
        System.out.println("Fib 9: " + fibb.apply(9));
    }

    private static boolean isPrime(int n, int i) {
        if (n <= 2)
            return n == 2;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        return isPrime(n, i + 1);
    }

    private static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
