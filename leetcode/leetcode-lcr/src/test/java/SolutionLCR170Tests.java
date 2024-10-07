import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR170Tests {
    private final SolutionLCR170 solutionLCR170 = new SolutionLCR170();

    @Test
    public void example1() {
        int[] nums = {7, 5, 6, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCR170.reversePairs(nums));
    }
}
