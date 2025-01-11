import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3381Tests {
    private final Solution3381 solution3381 = new Solution3381();

    @Test
    public void example1() {
        int[] nums = {1, 2};
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3381.maxSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 4;
        int expected = -10;
        Assertions.assertEquals(expected, solution3381.maxSubarraySum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {-5, 1, 2, -3, 4};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3381.maxSubarraySum(nums, k));
    }
}