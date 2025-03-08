import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3473Tests {
    private final Solution3473 solution3473 = new Solution3473();

    @Test
    public void example1() {
        int[] nums = {1, 2, -1, 3, 3, 4};
        int k = 2;
        int m = 2;
        int expected = 13;
        Assertions.assertEquals(expected, solution3473.maxSum(nums, k, m));
    }

    @Test
    public void example2() {
        int[] nums = {-10, 3, -1, -2};
        int k = 4;
        int m = 1;
        int expected = -10;
        Assertions.assertEquals(expected, solution3473.maxSum(nums, k, m));
    }
}