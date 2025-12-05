import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3755Tests {
    private final Solution3755 solution3755 = new Solution3755();

    @Test
    public void example1() {
        int[] nums = {3, 1, 3, 2, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solution3755.maxBalancedSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 8, 5, 4, 14, 9, 15};
        int expected = 8;
        Assertions.assertEquals(expected, solution3755.maxBalancedSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution3755.maxBalancedSubarray(nums));
    }
}