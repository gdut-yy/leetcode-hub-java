import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2036Tests {
    private final Solution2036 solution2036 = new Solution2036();

    @Test
    public void example1() {
        int[] nums = {3, -1, 1, 2};
        long expected = 5;
        Assertions.assertEquals(expected, solution2036.maximumAlternatingSubarraySum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2,2,2,2,2};
        long expected = 2;
        Assertions.assertEquals(expected, solution2036.maximumAlternatingSubarraySum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        long expected = 1;
        Assertions.assertEquals(expected, solution2036.maximumAlternatingSubarraySum(nums));
    }
}