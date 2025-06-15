import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3576Tests {
    private final Solution3576 solution3576 = new Solution3576();

    @Test
    public void example1() {
        int[] nums = {1, -1, 1, -1, 1};
        int k = 3;
        Assertions.assertTrue(solution3576.canMakeEqual(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -1, -1, 1, 1, 1};
        int k = 5;
        Assertions.assertFalse(solution3576.canMakeEqual(nums, k));
    }
}