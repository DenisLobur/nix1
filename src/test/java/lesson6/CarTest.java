package lesson6;

import lesson6.Car;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {

    Car honda;
    Car toyota;
    long hondaInspectionDate = 1634936400000L; //2021-10-23-00:00
    long toyotaInspectionDate = 1571778000000L; //2019-10-23-00:00

    @BeforeAll
    void init() {
        honda = new Car(10, 10, hondaInspectionDate);
        toyota = new Car(16, 5, toyotaInspectionDate);
    }

    @Test
    @DisplayName("Check if car can ride")
    public void testIfCanRide() {
        Assertions.assertTrue(honda.canRide());
        Assertions.assertTrue(toyota.canRide());
    }

    @Test
    @DisplayName("Check if car operational")
    public void testIfOperational() {
        Assertions.assertTrue(honda.isOperational());
        Assertions.assertFalse(toyota.isOperational());
    }

    @Test
    @DisplayName("Check left to run")
    public void testLeftToRun() {
        double hondaLeftToRun = 100;
        double toyotaLeftToRun = 320;
        Assertions.assertEquals(hondaLeftToRun, honda.leftToRun());
        Assertions.assertEquals(toyotaLeftToRun, toyota.leftToRun());
    }
}
