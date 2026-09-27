import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3958Tests {
    private final SolutionP3958 solutionP3958 = new SolutionP3958();

    @Test
    public void example1() {
        int n = 3;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP3958.minCost(n));
    }

    @Test
    public void example2() {
        int n = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solutionP3958.minCost(n));
    }
}
