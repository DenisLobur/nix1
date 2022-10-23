package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeTest {

    @Test
    void checkIfTenPrime() {
        boolean ten = Prime.isPrime(10, 2);
        Assertions.assertFalse(ten);
    }

    @Test
    void checkIfElevenPrime() {
        boolean eleven = Prime.isPrime(11, 2);
        Assertions.assertTrue(eleven);
    }

    @Test
    void checkIfNinetyNinePrime() {
        boolean ninetyNine = Prime.isPrime(99, 2);
        Assertions.assertFalse(ninetyNine);
    }

    @Test
    void checkIfZeroPrime() {
        boolean zero = Prime.isPrime(0, 2);
        Assertions.assertFalse(zero);
    }

    @Test
    void checkIfNegativePrime() {
        boolean minusFour = Prime.isPrime(-4, 2);
        Assertions.assertFalse(minusFour);
    }
}