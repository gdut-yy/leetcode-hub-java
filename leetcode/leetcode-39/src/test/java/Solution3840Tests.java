import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3840Tests {
    private final Solution3840 solution3840 = new Solution3840();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 5};
        int[] colors = {1, 1, 2, 2};
        long expected = 9;
        Assertions.assertEquals(expected, solution3840.rob(nums, colors));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 2, 4};
        int[] colors = {2, 3, 2, 2};
        long expected = 8;
        Assertions.assertEquals(expected, solution3840.rob(nums, colors));
    }

    @Test
    public void example3() {
        int[] nums = {10, 1, 3, 9};
        int[] colors = {1, 1, 1, 2};
        long expected = 22;
        Assertions.assertEquals(expected, solution3840.rob(nums, colors));
    }
}