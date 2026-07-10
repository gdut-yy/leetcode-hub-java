import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3976Tests {
    private final Solution3976 solution3976 = new Solution3976();

    @Test
    public void example1() {
        int[] nums = {1, -2, 3, 4, -5};
        int k = 2;
        long expected = 14;
        Assertions.assertEquals(expected, solution3976.maxSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-5, -4, -3};
        int k = 2;
        long expected = -1;
        Assertions.assertEquals(expected, solution3976.maxSubarraySum(nums, k));
    }
}