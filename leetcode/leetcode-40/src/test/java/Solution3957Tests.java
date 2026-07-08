import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3957Tests {
    private final Solution3957 solution3957 = new Solution3957();

    @Test
    public void example1() {
        int[] nums = {4, 1, -5, 2};
        int m = 2;
        int l = 1;
        int r = 3;
        long expected = 7;
        Assertions.assertEquals(expected, solution3957.maximumSum(nums, m, l, r));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 3, 4};
        int m = 2;
        int l = 1;
        int r = 2;
        long expected = 8;
        Assertions.assertEquals(expected, solution3957.maximumSum(nums, m, l, r));
    }

    @Test
    public void example3() {
        int[] nums = {-1, 7, -4};
        int m = 1;
        int l = 2;
        int r = 3;
        long expected = 6;
        Assertions.assertEquals(expected, solution3957.maximumSum(nums, m, l, r));
    }

    @Test
    public void example4() {
        int[] nums = {-3, -4, -1};
        int m = 2;
        int l = 1;
        int r = 2;
        long expected = -1;
        Assertions.assertEquals(expected, solution3957.maximumSum(nums, m, l, r));
    }
}