import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3719Tests {
    private final Solution3719 solution3719 = new Solution3719();

    @Test
    public void example1() {
        int[] nums = {2, 5, 4, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution3719.longestBalanced(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 2, 5, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution3719.longestBalanced(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3719.longestBalanced(nums));
    }
}