import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution280Tests {
    private final Solution280 solution280 = new Solution280();

    @Test
    public void example1() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        solution280.wiggleSort(nums);
        Assertions.assertTrue(check(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 6, 5, 6, 3, 8};
        solution280.wiggleSort(nums);
        Assertions.assertTrue(check(nums));
    }

    private boolean check(int[] nums) {
        boolean less = true;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
            less = !less;
        }
        return true;
    }
}
