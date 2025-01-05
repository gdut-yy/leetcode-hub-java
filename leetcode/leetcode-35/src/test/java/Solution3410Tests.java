import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3410Tests {
    private final Solution3410 solution3410 = new Solution3410();

    @Test
    public void example1() {
        int[] nums = {-3, 2, -2, -1, 3, -2, 3};
        long expected = 7;
        Assertions.assertEquals(expected, solution3410.maxSubarraySum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        long expected = 10;
        Assertions.assertEquals(expected, solution3410.maxSubarraySum(nums));
    }
}