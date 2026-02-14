import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3830Tests {
    private final Solution3830 solution3830 = new Solution3830();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution3830.longestAlternating(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1, 2, 3, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3830.longestAlternating(nums));
    }

    @Test
    public void example3() {
        int[] nums = {100000, 100000};
        int expected = 1;
        Assertions.assertEquals(expected, solution3830.longestAlternating(nums));
    }
}