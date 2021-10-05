import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO10_2Tests {
    private final SolutionO10_2 solutionO10_2 = new SolutionO10_2();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionO10_2.numWays(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 21;
        Assertions.assertEquals(expected, solutionO10_2.numWays(n));
    }

    @Test
    public void example3() {
        int n = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionO10_2.numWays(n));
    }
}
