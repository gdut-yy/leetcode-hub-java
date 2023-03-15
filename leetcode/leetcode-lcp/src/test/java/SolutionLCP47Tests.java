import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP47Tests {
    private final SolutionLCP47 solutionLCP47 = new SolutionLCP47();

    @Test
    public void example1() {
        int[] capacities = {2, 2, 3};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP47.securityCheck(capacities, k));
    }

    @Test
    public void example2() {
        int[] capacities = {3, 3};
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP47.securityCheck(capacities, k));
    }

    @Test
    public void example3() {
        int[] capacities = {4, 3, 2, 2};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP47.securityCheck(capacities, k));
    }
}
