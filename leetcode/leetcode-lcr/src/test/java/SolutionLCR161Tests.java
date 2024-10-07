import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR161Tests {
    private final SolutionLCR161 solutionLCR161 = new SolutionLCR161();

    @Test
    public void example1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCR161.maxSales(nums));
    }
}
