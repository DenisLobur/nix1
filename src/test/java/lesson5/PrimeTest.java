package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PrimeTest {

    @Test
    void checkIfTenPrime() {
        boolean isTenPrime = Prime.isPrime(10, 2);
        Assertions.assertFalse(isTenPrime);
    }

    @Test
    void checkIfElevenPrime() {
        boolean isElevenPrime = Prime.isPrime(11, 2);
        Assertions.assertTrue(isElevenPrime);
    }

    @Test
    void checkIfNinetyNinePrime() {
        boolean isNinetyNinePrime = Prime.isPrime(99, 2);
        Assertions.assertFalse(isNinetyNinePrime);
    }

    @Test
    void checkIfZeroPrime() {
        boolean isZero = Prime.isPrime(0, 2);
        Assertions.assertFalse(isZero);
    }

    @Test
    void checkIfNegativePrime() {
        boolean isMinusFourPrime = Prime.isPrime(-4, 2);
        Assertions.assertFalse(isMinusFourPrime);
    }
}