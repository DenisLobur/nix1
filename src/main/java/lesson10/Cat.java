package lesson10;

import lesson4.WeekDays;

import java.util.Objects;

public class Cat extends Predator {

    private final Breed breed;

    public Cat(Breed breed, Color color, int weight) {
        super(color, weight);
        this.breed = breed;
    }

    @Override
    protected String sleep() {
        return "Sleeping";
    }

    @Override
    protected String hunt() {
        return "Hunting";
    }

    private String makeSomeNoise() {
        return "Tygydyk";
    }

    private String lickBalls() {
        return "Licking balls";
    }

    public String currentActivity(WeekDays today) {
        return switch (today) {
            case MON, WED, FRI -> sleep();
            case TUE, THU, SAT -> hunt();
            case SUN -> makeSomeNoise();
            default -> lickBalls();
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        return Objects.equals(breed, cat.breed) && super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = breed != null ? breed.hashCode() : 0;
        result = 31 * result + super.hashCode();
        return result;
    }
}
