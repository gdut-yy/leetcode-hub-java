import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP17Tests {
    private final SolutionLCP17 solutionLCP17 = new SolutionLCP17();

    @Test
    public void example1() {
        String s = "AB";
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP17.calculate(s));
    }
}
