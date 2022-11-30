package lesson14;

import lesson14.comparators.CapacityComparator;
import lesson14.comparators.Car;
import lesson14.comparators.YearComparator;
import lesson14.iterators.Range;
import lesson14.iterators.RangeWithStep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CollectionsTest {
    private final YearComparator yearComparator = new YearComparator();
    private final CapacityComparator capacityComparator = new CapacityComparator();

    private final List<Car> cars = new ArrayList<>();
    private final Set<Car> carsSet = new TreeSet<>(capacityComparator);

    private final Range range = new Range(1, 10);
    private final Range decrRange = new Range(10, 1);
    private final RangeWithStep rangeWithStep = new RangeWithStep(1, 10, 2);
    private final RangeWithStep decreaseRangeWithStep = new RangeWithStep(10, 1, 3);

    private int paramCounter;
    private int counter;

    @BeforeEach
    void resetCounter() {
        counter = 0;
    }

    @BeforeAll
    void initData() {
        cars.add(new Car(2012, 2.0));
        cars.add(new Car(2022, 2.5));
        cars.add(new Car(1980, 1.5));

        carsSet.add(new Car(2012, 2.0));
        carsSet.add(new Car(2022, 2.5));
        carsSet.add(new Car(2002, 1.5));
    }

    @ParameterizedTest
    @ValueSource(ints = {1980, 2012, 2022})
    void checkSortByYear(int input) {
        cars.sort(yearComparator);
        assertEquals(input, cars.get(paramCounter).getYearOfManufacture());
        paramCounter++;
    }

    @Test
    void checkSortByCapacity() {
        double[] expectedCapacity = {1.5, 2.0, 2.5};

        for (Car car : carsSet) {
            assertEquals(expectedCapacity[counter], car.getEngineCapacity());
            counter++;
        }
    }

    @Test
    void testIncreaseRange() {
        int[] expectedInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Integer actualInt : range) {
            assertEquals(expectedInt[counter], actualInt);
            counter++;
        }
    }

    @Test
    void testDecreaseRange() {
        int[] expectedInt = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (Integer actualInt : decrRange) {
            assertEquals(expectedInt[counter], actualInt);
            counter++;
        }
    }

    @Test
    void testIncreaseRangeWithStep() {
        int[] expectedInt = {1, 3, 5, 7, 9};
        for (Integer actualInt : rangeWithStep) {
            assertEquals(expectedInt[counter], actualInt);
            counter++;
        }
    }

    @Test
    void testDecreaseRangeWithStep() {
        int[] expectedInt = {10, 7, 4};
        for (Integer actualInt : decreaseRangeWithStep) {
            System.out.println(actualInt);
            assertEquals(expectedInt[counter], actualInt);
            counter++;
        }
    }
}
