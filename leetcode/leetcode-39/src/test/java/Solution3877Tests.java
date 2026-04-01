import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3877Tests {
    private final Solution3877 solution3877 = new Solution3877();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int target = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3877.minRemovals(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4};
        int target = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3877.minRemovals(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {7};
        int target = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution3877.minRemovals(nums, target));
    }
}