import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1696Tests {
    private final Solution1696 solution1696 = new Solution1696();

    @Test
    public void example1() {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1696.maxResult2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int expected = 17;
        Assertions.assertEquals(expected, solution1696.maxResult2(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution1696.maxResult2(nums, k));
    }
}