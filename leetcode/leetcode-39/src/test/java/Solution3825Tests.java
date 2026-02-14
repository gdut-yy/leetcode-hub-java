import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3825Tests {
    private final Solution3825 solution3825 = new Solution3825();

    @Test
    public void example1() {
        int[] nums = {5, 4, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution3825.longestSubsequence(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution3825.longestSubsequence(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3825.longestSubsequence(nums));
    }
}