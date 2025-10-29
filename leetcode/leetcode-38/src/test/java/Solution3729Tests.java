import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3729Tests {
    private final Solution3729 solution3729 = new Solution3729();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 3;
        long expected = 3;
        Assertions.assertEquals(expected, solution3729.numGoodSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2, 2};
        int k = 6;
        long expected = 2;
        Assertions.assertEquals(expected, solution3729.numGoodSubarrays(nums, k));
    }
}