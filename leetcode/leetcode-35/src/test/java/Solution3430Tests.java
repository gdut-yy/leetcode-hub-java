import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3430Tests {
    private final Solution3430 solution3430 = new Solution3430();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 2;
        long expected = 20;
        Assertions.assertEquals(expected, solution3430.minMaxSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, -3, 1};
        int k = 2;
        long expected = -6;
        Assertions.assertEquals(expected, solution3430.minMaxSubarraySum(nums, k));
    }
}