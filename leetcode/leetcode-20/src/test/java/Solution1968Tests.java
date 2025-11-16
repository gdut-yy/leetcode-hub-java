import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1968Tests {
    private final Solution1968.V1 solution1968_v1 = new Solution1968.V1();
    private final Solution1968.V2 solution1968_v2 = new Solution1968.V2();

    private boolean checkArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == nums[i] + nums[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 4, 5, 3};
        Assertions.assertTrue(checkArray(solution1968_v1.rearrangeArray(nums)));
        Assertions.assertTrue(checkArray(solution1968_v2.rearrangeArray(nums)));
    }

    @Test
    public void example2() {
        int[] nums = {6, 2, 0, 9, 7};
        int[] expected = {9, 7, 6, 2, 0};
        Assertions.assertTrue(checkArray(solution1968_v1.rearrangeArray(nums)));
        Assertions.assertTrue(checkArray(solution1968_v2.rearrangeArray(nums)));
    }
}
