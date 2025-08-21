import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3640Tests {
    private final Solution3640 solution3640 = new Solution3640();

    @Test
    public void example1() {
        int[] nums = {0, -2, -1, -3, 0, 2, -1};
        long expected = -4;
        Assertions.assertEquals(expected, solution3640.maxSumTrionic(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 7};
        long expected = 14;
        Assertions.assertEquals(expected, solution3640.maxSumTrionic(nums));
    }
}