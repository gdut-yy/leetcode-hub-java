import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR189Tests {
    private final SolutionLCR189 solutionLCR189 = new SolutionLCR189();

    @Test
    public void example1() {
        int n = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCR189.mechanicalAccumulator(n));
    }

    @Test
    public void example2() {
        int n = 9;
        int expected = 45;
        Assertions.assertEquals(expected, solutionLCR189.mechanicalAccumulator(n));
    }
}
