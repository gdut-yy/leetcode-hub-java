import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP11Tests {
    private final SolutionLCP11 solutionLCP11 = new SolutionLCP11();

    @Test
    public void example1() {
        int[] scores = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP11.expectNumber(scores));
    }

    @Test
    public void example2() {
        int[] scores = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP11.expectNumber(scores));
    }

    @Test
    public void example3() {
        int[] scores = {1, 1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP11.expectNumber(scores));
    }
}
