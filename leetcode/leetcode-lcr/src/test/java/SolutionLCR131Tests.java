import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR131Tests {
    private final SolutionLCR131 solutionLCR131 = new SolutionLCR131();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR131.cuttingBamboo(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 36;
        Assertions.assertEquals(expected, solutionLCR131.cuttingBamboo(n));
    }
}
