package lesson16;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StreamsTest {

    private List<Person> persons;

    @BeforeAll
    void initData() {
        persons = List.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person("Іван Іванович", 69, Sex.MAN)
        );
    }

    @Test
    void checkWomenAged18To60() {
        List<Person> expected = List.of(new Person("Олена", 42, Sex.WOMAN));
        List<Person> actual = StreamRunner.getWomenAged(
                persons,
                person -> person.getAge() >= 18 && person.getAge() <= 60 && person.getSex() == Sex.WOMAN
        );
        assertEquals(expected, actual);
    }

    @Test
    void checkAverageAgeAmongMen() {
        double expected = 36.0;
        double actual = StreamRunner.averageAgeAmongMen(
                persons,
                person -> person.getSex() == Sex.MAN
        );
        assertEquals(expected, actual);
    }

    @Test
    void checkWorkAgedPeople() {
        int expected = 2;

        int actual = StreamRunner.findNumberOfWorkAged(
                persons,
                person -> person.getAge() >= 18,
                person -> person.getSex() == Sex.MAN && person.getAge() <= 60,
                person -> person.getSex() == Sex.WOMAN && person.getAge() <= 55
        );

        assertEquals(expected, actual);
    }
}
