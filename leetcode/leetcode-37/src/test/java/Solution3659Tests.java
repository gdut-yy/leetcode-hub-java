import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3659Tests {
    private final Solution3659 solution3659 = new Solution3659();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        Assertions.assertTrue(solution3659.partitionArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 5, 2, 2};
        int k = 2;
        Assertions.assertTrue(solution3659.partitionArray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 5, 2, 3};
        int k = 3;
        Assertions.assertFalse(solution3659.partitionArray(nums, k));
    }
}