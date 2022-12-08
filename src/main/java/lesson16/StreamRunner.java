package lesson16;

import java.util.List;
import java.util.function.Predicate;

public class StreamRunner {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person("Іван Іванович", 69, Sex.MAN)
        );

        System.out.println("Women age 18 <> 60: " + getWomenAged(
                persons,
                person -> person.getAge() >= 18 && person.getAge() <= 60 && person.getSex() == Sex.WOMAN
        ));

        System.out.println("Average men age: " + averageAgeAmongMen(
                persons,
                person -> person.getSex() == Sex.MAN
        ));

        System.out.println("WorkAged people: " + findNumberOfWorkAged(
                persons,
                person -> person.getAge() >= 18,
                (person -> person.getSex() == Sex.MAN && person.getAge() <= 60),
                (person -> person.getSex() == Sex.WOMAN && person.getAge() <= 55)
        ));
    }

    // TODO: Select women aged 18 <> 60
    public static List<Person> getWomenAged(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream().filter(predicate).toList();
    }

    //TODO: Find average age among all men
    public static double averageAgeAmongMen(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream().filter(predicate).mapToInt(person -> person.getAge()).average().orElse(0);
    }

    //TODO: Find number of workAged people
    public static int findNumberOfWorkAged(List<Person> persons, Predicate<Person> greaterThan, Predicate<Person> menByAge, Predicate<Person> womenByAge) {
        List<Person> menWorkAged = persons.stream().filter(greaterThan).filter(menByAge).toList();
        List<Person> womenWorkAged = persons.stream().filter(greaterThan).filter(womenByAge).toList();
        return menWorkAged.size() + womenWorkAged.size();
    }
}
