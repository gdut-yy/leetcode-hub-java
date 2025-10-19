import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3708Tests {
    private final Solution3708 solution3708 = new Solution3708();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 2, 3, 5, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solution3708.longestSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 2, 7, 9, 16};
        int expected = 5;
        Assertions.assertEquals(expected, solution3708.longestSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1000000000, 1000000000, 1000000000};
        int expected = 2;
        Assertions.assertEquals(expected, solution3708.longestSubarray(nums));
    }
}