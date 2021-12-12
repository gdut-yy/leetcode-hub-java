import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5934Tests {
    private final Solution5934 solution5934 = new Solution5934();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 3};
        int k = 2;
        int[] expected = {3, 3};
        Assertions.assertArrayEquals(expected, solution5934.maxSubsequence(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -2, 3, 4};
        int k = 3;
        int[] expected = {-1, 3, 4};
        Assertions.assertArrayEquals(expected, solution5934.maxSubsequence(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 4, 3, 3};
        int k = 2;
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution5934.maxSubsequence(nums, k));
    }
}
