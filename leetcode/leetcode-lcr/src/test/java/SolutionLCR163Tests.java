import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR163Tests {
    private final SolutionLCR163 solutionLCR163 = new SolutionLCR163();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCR163.findKthNumber(n));
    }

    @Test
    public void example2() {
        int n = 11;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCR163.findKthNumber(n));
    }
}
