import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3687Tests {
    private final SolutionP3687 solutionP3687 = new SolutionP3687();

    @Test
    public void example1() {
        int[] daysLate = {5, 1, 7};
        int expected = 32;
        Assertions.assertEquals(expected, solutionP3687.lateFee(daysLate));
    }

    @Test
    public void example2() {
        int[] daysLate = {1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3687.lateFee(daysLate));
    }
}