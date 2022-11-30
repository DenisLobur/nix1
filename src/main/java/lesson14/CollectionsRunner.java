package lesson14;

import lesson14.comparators.CapacityComparator;
import lesson14.comparators.Car;
import lesson14.comparators.YearComparator;
import lesson14.iterators.Range;
import lesson14.iterators.RangeWithStep;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
        YearComparator yearComparator = new YearComparator();
        CapacityComparator capacityComparator = new CapacityComparator();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2012, 2.0));
        cars.add(new Car(2022, 2.5));
        cars.add(new Car(1980, 1.5));
        System.out.println("Before sorting by year: " + cars);
        cars.sort(yearComparator);
        System.out.println("After sorting by year: " + cars);

        Set<Car> carsSet = new TreeSet<>(capacityComparator);
        carsSet.add(new Car(2012, 2.0));
        carsSet.add(new Car(2022, 2.5));
        carsSet.add(new Car(2002, 1.5));
        System.out.println("Sorting by growing capacity: " + carsSet);

        Range range = new Range(9, 2);
        System.out.println("Looping through Range [9..2)");
        for (Integer integer : range) {
            System.out.println(integer);
        }

        RangeWithStep rangeWithStep = new RangeWithStep(1, 10, 2);
        System.out.println("Looping through RangeWithStep [1..10) step: 2");
        for (Integer integer : rangeWithStep) {
            System.out.println(integer);
        }
    }
}
