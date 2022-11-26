package lesson14;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {

    @Override
    public int compare(Car carOne, Car carTwo) {
        return Integer.compare(carOne.getYearOfManufacture(), carTwo.getYearOfManufacture());
    }
}
