package lesson10;

public abstract class Predator {

    private final Color color;
    private final int weight;

    protected Predator(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    protected abstract String sleep();

    protected abstract String hunt();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Predator predator = (Predator) o;

        if (weight != predator.weight) return false;
        return color.equals(predator.color);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
