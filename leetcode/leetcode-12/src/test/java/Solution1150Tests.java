import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1150Tests {
    private final Solution1150 solution1150 = new Solution1150();

        @Test
        public void example1() {
        int[] nums = {2, 4, 5, 5, 5, 5, 5, 6, 6};
        int target = 5;
        Assertions.assertTrue(solution1150.isMajorityElement(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {10, 100, 101, 101};
        int target = 101;
        Assertions.assertFalse(solution1150.isMajorityElement(nums, target));
    }
}
