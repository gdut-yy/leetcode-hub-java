import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1918Tests {
    private final Solution1918 solution1918 = new Solution1918();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution1918.kthSmallestSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 5, 5};
        int k = 7;
        int expected = 10;
        Assertions.assertEquals(expected, solution1918.kthSmallestSubarraySum(nums, k));
    }
}