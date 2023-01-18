import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution548Tests {
    private final Solution548 solution548 = new Solution548();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1};
        Assertions.assertTrue(solution548.splitArray(nums));
        Assertions.assertTrue(solution548.splitArray2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
        Assertions.assertFalse(solution548.splitArray(nums));
        Assertions.assertFalse(solution548.splitArray2(nums));
    }
}
