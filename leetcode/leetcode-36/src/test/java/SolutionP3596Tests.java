import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3596Tests {
    private final SolutionP3596 solutionP3596 = new SolutionP3596();

    @Test
    public void example1() {
        int m = 1;
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3596.minCost(m, n));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3596.minCost(m, n));
    }
}