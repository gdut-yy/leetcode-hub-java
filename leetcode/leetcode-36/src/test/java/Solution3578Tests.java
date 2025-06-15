import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3578Tests {
    private final Solution3578 solution3578 = new Solution3578();

    @Test
    public void example1() {
        int[] nums = {9, 4, 1, 3, 7};
        int k = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution3578.countPartitions(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 4};
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3578.countPartitions(nums, k));
    }
}