import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO42Tests {
    private final SolutionO42 solutionO42 = new SolutionO42();

    @Test
    public void example1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solutionO42.maxSubArray(nums));
    }
}
