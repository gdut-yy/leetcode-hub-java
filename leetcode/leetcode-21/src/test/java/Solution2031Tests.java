import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2031Tests {
    private final Solution2031 solution2031 = new Solution2031();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 0, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution2031.subarraysWithMoreZerosThanOnes(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution2031.subarraysWithMoreZerosThanOnes(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution2031.subarraysWithMoreZerosThanOnes(nums));
    }
}