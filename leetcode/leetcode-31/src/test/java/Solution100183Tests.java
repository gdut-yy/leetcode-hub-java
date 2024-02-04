import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100183Tests {
    private final Solution100183 solution100183 = new Solution100183();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 1;
        long expected = 11;
        Assertions.assertEquals(expected, solution100183.maximumSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 3, 2, 4, 5};
        int k = 3;
        long expected = 11;
        Assertions.assertEquals(expected, solution100183.maximumSubarraySum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -2, -3, -4};
        int k = 2;
        long expected = -6;
        Assertions.assertEquals(expected, solution100183.maximumSubarraySum(nums, k));
    }
}