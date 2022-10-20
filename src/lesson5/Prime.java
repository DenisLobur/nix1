package lesson5;

public class Prime {
    public static boolean isPrime(int n, int i) {
        if (n <= 2)
            return n == 2;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        return isPrime(n, i + 1);
    }
}
