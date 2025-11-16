import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3737Tests {
    private final Solution3737 solution3737 = new Solution3737();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3};
        int target = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution3737.countMajoritySubarrays(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int target = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution3737.countMajoritySubarrays(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution3737.countMajoritySubarrays(nums, target));
    }
}