package lesson6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Getter
    private double tankCapacity;
    @Getter
    private double fuelPerHundredKm;
    @Getter
    private long lastInspectionTime;

    public boolean canRide() {
        return tankCapacity > 0.0;
    }

    public boolean isOperational() {
        long twoYearsInMillis = 2 * 31536000000L;
        return (System.currentTimeMillis() - lastInspectionTime) < twoYearsInMillis;
    }

    public double leftToRun() {
        return 100 / fuelPerHundredKm * tankCapacity;
    }
}
