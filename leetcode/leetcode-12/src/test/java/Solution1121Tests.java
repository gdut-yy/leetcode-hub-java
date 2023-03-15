import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1121Tests {
    private final Solution1121 solution1121 = new Solution1121();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 3, 4, 4};
        int k = 3;
        Assertions.assertTrue(solution1121.canDivideIntoSubsequences(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 6, 7, 8};
        int k = 3;
        Assertions.assertFalse(solution1121.canDivideIntoSubsequences(nums, k));
    }
}