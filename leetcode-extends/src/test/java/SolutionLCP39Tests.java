import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP39Tests {
    private final SolutionLCP39 solutionLCP39 = new SolutionLCP39();

    @Test
    public void example1() {
        int[][] source = {{1, 3}, {5, 4}};
        int[][] target = {{3, 1}, {6, 5}};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP39.minimumSwitchingTimes(source, target));
    }

    @Test
    public void example2() {
        int[][] source = {{1, 2, 3}, {3, 4, 5}};
        int[][] target = {{1, 3, 5}, {2, 3, 4}};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP39.minimumSwitchingTimes(source, target));
    }
}
