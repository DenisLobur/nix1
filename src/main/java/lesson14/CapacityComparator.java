package lesson14;

import java.util.Comparator;

public class CapacityComparator implements Comparator<Car> {

    @Override
    public int compare(Car carOne, Car carTwo) {
        return Double.compare(carOne.getEngineCapacity(), carTwo.getEngineCapacity());
    }
}
