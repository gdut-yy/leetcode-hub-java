import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP06Tests {
    private final SolutionLCP06 solutionLCP06 = new SolutionLCP06();

    @Test
    public void example1() {
        int[] coins = {4, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP06.minCount(coins));
    }

    @Test
    public void example2() {
        int[] coins = {2, 3, 10};
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP06.minCount(coins));
    }
}
