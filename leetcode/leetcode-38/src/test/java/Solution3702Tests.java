import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3702Tests {
    private final Solution3702 solution3702 = new Solution3702();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3702.longestSubsequence(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution3702.longestSubsequence(nums));
    }
}