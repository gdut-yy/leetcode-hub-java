import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3942Tests {
    private final Solution3942 solution3942 = new Solution3942();

    @Test
    public void example1() {
        int[] nums = {0, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3942.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3942.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 0, 1, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution3942.minOperations(nums));
    }
}