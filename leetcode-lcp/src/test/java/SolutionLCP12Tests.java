import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP12Tests {
    private final SolutionLCP12 solutionLCP12 = new SolutionLCP12();

    @Test
    public void example1() {
        int[] time = {1, 2, 3, 3};
        int m = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP12.minTime(time, m));
    }

    @Test
    public void example2() {
        int[] time = {999, 999, 999};
        int m = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP12.minTime(time, m));
    }
}
