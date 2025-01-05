import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3409Tests {
    private final Solution3409 solution3409 = new Solution3409();

    @Test
    public void example1() {
        int[] nums = {16, 6, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3409.longestSubsequence(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 3, 4, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3409.longestSubsequence(nums));
    }

    @Test
    public void example3() {
        int[] nums = {10, 20, 10, 19, 10, 20};
        int expected = 5;
        Assertions.assertEquals(expected, solution3409.longestSubsequence(nums));
    }
}