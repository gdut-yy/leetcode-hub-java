import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3524Tests {
    private final Solution3524 solution3524 = new Solution3524();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        long[] expected = {9, 2, 4};
        Assertions.assertArrayEquals(expected, solution3524.resultArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 8, 16, 32};
        int k = 4;
        long[] expected = {18, 1, 2, 0};
        Assertions.assertArrayEquals(expected, solution3524.resultArray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 2;
        long[] expected = {9, 6};
        Assertions.assertArrayEquals(expected, solution3524.resultArray(nums, k));
    }
}