import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3962Tests {
    private final Solution3962 solution3962 = new Solution3962();

    @Test
    public void example1() {
        int[] nums = {1, -1, 0, 2};
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3962.maxSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 2, 4};
        int k = 2;
        int expected = 13;
        Assertions.assertEquals(expected, solution3962.maxSum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -2};
        int k = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution3962.maxSum(nums, k));
    }
}