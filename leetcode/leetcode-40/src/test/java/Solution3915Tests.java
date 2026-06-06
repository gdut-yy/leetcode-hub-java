import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3915Tests {
    private final Solution3915 solution3915 = new Solution3915();

    @Test
    public void example1() {
        int[] nums = {5, 4, 2};
        int k = 2;
        long expected = 7;
        Assertions.assertEquals(expected, solution3915.maxAlternatingSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 5, 4, 2, 4};
        int k = 1;
        long expected = 14;
        Assertions.assertEquals(expected, solution3915.maxAlternatingSum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5};
        int k = 1;
        long expected = 5;
        Assertions.assertEquals(expected, solution3915.maxAlternatingSum(nums, k));
    }
}