import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3738Tests {
    private final Solution3738 solution3738 = new Solution3738();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution3738.longestSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution3738.longestSubarray(nums));
    }
}