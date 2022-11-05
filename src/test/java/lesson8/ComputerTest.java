package lesson8;

import lesson4.WeekDays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ComputerTest {

    private final Computer computer = new Computer.ComputerBuilder()
            .name("CP")
            .ram(32)
            .cores(16)
            .number()
            .operatingSystem(Computer.OperatingSystem.Linux)
            .build();
    @Test
    void checkTranspose() {
        int[][] initialMatrix = {{1, 2}, {3, 4}, {5, 6}};
        int[][] expectedMatrix = {{1, 3, 5}, {2, 4, 6}};
        assertThat(computer.transpose(initialMatrix)).isEqualTo(expectedMatrix);
    }

    @Test
    void checkWorkingMood() {
        assertThat(computer.calculateWorkingMood(WeekDays.MON)).contains("work").doesNotContain("rest");
        assertThat(computer.calculateWorkingMood(WeekDays.TUE)).contains("work").doesNotContain("rest");
        assertThat(computer.calculateWorkingMood(WeekDays.WED)).contains("work").doesNotContain("rest");
        assertThat(computer.calculateWorkingMood(WeekDays.THU)).contains("work").doesNotContain("rest");
        assertThat(computer.calculateWorkingMood(WeekDays.FRI)).contains("work").doesNotContain("rest");
        assertThat(computer.calculateWorkingMood(WeekDays.SAT)).contains("rest").doesNotContain("work");
        assertThat(computer.calculateWorkingMood(WeekDays.SUN)).contains("rest").doesNotContain("work");
    }

    @Test
    void checkIfCanRunGames() {
        assertThat(computer.canRunGames()).isTrue();
    }

    @Test
    void checkIfSupportsXCode() {
        assertThat(computer.supportsXcode()).isFalse();
    }
}
