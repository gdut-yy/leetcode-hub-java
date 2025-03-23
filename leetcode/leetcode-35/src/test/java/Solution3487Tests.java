import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3487Tests {
    private final Solution3487 solution3487 = new Solution3487();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 15;
        Assertions.assertEquals(expected, solution3487.maxSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 0, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3487.maxSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, -1, -2, 1, 0, -1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3487.maxSum(nums));
    }
}