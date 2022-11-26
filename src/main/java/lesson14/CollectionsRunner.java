package lesson14;

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
    }
}
