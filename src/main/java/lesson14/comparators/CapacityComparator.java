package lesson14.comparators;

import lesson14.comparators.Car;

import java.util.Comparator;

public class CapacityComparator implements Comparator<Car> {

    @Override
    public int compare(Car carOne, Car carTwo) {
        return Double.compare(carOne.getEngineCapacity(), carTwo.getEngineCapacity());
    }
}
