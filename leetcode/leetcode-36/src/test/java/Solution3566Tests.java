import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3566Tests {
    private final Solution3566 solution3566 = new Solution3566();

    @Test
    public void example1() {
        int[] nums = {3, 1, 6, 8, 4};
        long target = 24;
        Assertions.assertTrue(solution3566.checkEqualPartitions(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {2, 5, 3, 7};
        long target = 15;
        Assertions.assertFalse(solution3566.checkEqualPartitions(nums, target));
    }
}