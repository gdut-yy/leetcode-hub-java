import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP61Tests {
    private final SolutionLCP61 solutionLCP61 = new SolutionLCP61();

    @Test
    public void example1() {
        int[] temperatureA = {21, 18, 18, 18, 31};
        int[] temperatureB = {34, 32, 16, 16, 17};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP61.temperatureTrend(temperatureA, temperatureB));
    }

    @Test
    public void example2() {
        int[] temperatureA = {5, 10, 16, -6, 15, 11, 3};
        int[] temperatureB = {16, 22, 23, 23, 25, 3, -16};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP61.temperatureTrend(temperatureA, temperatureB));
    }
}
