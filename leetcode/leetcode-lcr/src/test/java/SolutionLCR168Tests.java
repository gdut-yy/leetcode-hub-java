import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR168Tests {
    private final SolutionLCR168 solutionLCR168 = new SolutionLCR168();

    @Test
    public void example1() {
        int n = 10;
        int expected = 12;
        Assertions.assertEquals(expected, solutionLCR168.nthUglyNumber(n));
    }
}
