package lesson10;

public class CatRunner {
    public static void main(String[] args) {
        Cat bob = new Cat(Breed.SIAMESE, Color.RED, 10);
        Cat tod = new Cat(Breed.SIAMESE, Color.RED, 10);
        System.out.printf("Are those cats equal? %b", bob.equals(tod));
    }
}
