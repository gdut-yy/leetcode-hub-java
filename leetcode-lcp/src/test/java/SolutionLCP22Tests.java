import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP22Tests {
    private final SolutionLCP22 solutionLCP22 = new SolutionLCP22();

    @Test
    public void example1() {
        int n = 2;
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP22.paintingPlan(n, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP22.paintingPlan(n, k));
    }

    @Test
    public void example3() {
        int n = 2;
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP22.paintingPlan(n, k));
    }
}
