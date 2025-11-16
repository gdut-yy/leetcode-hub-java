import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3739Tests {
    private final Solution3739 solution3739 = new Solution3739();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3};
        int target = 2;
        long expected = 5;
        Assertions.assertEquals(expected, solution3739.countMajoritySubarrays(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int target = 1;
        long expected = 10;
        Assertions.assertEquals(expected, solution3739.countMajoritySubarrays(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int target = 4;
        long expected = 0;
        Assertions.assertEquals(expected, solution3739.countMajoritySubarrays(nums, target));
    }
}