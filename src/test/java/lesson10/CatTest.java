package lesson10;

import lesson4.WeekDays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class CatTest {

    private static final String SLEEP = "Sleeping";
    private static final String HUNT = "Hunting";
    private static final String TYG = "Tygydyk";
    private static final String LICK = "Licking balls";

    private final Cat bob = new Cat(Breed.SIAMESE, Color.RED, 10);
    private final Cat tod = new Cat(Breed.SIAMESE, Color.RED, 10);
    private final Cat pod = new Cat(Breed.PERSIAN, Color.GREEN, 5);


    @Test
    void checkEquality() {
        assertEquals(bob, tod);
        assertNotEquals(bob, pod);
        assertNotEquals(tod, pod);
        // checking if cat.equals(cat)
        assertEquals(bob, bob);
        // checking if cat.equals(obj)
        assertNotEquals(bob, new Object());
    }

    @ParameterizedTest
    @EnumSource(WeekDays.class)
    void checkActivity(WeekDays today) {
        String todaysActivity = bob.currentActivity(today);

        switch (today) {
            case MON -> assertEquals(todaysActivity, SLEEP);
            case TUE -> assertEquals(todaysActivity, HUNT);
            case WED -> assertEquals(todaysActivity, SLEEP);
            case THU -> assertEquals(todaysActivity, HUNT);
            case FRI -> assertEquals(todaysActivity, SLEEP);
            case SAT -> assertEquals(todaysActivity, HUNT);
            case SUN -> assertEquals(todaysActivity, TYG);
            default -> assertEquals(todaysActivity, LICK);
        }
    }
}
