import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3806Tests {
    private final Solution3806 solution3806 = new Solution3806();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2};
        int k = 8;
        int m = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution3806.maximumAND(nums, k, m));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 8, 4};
        int k = 7;
        int m = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3806.maximumAND(nums, k, m));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1};
        int k = 3;
        int m = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3806.maximumAND(nums, k, m));
    }
}