import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6169Tests {
    private final Solution6169 solution6169 = new Solution6169();

    @Test
    public void example1() {
        int[] nums = {1, 3, 8, 48, 10};
        int expected = 3;
        Assertions.assertEquals(expected, solution6169.longestNiceSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 5, 11, 13};
        int expected = 1;
        Assertions.assertEquals(expected, solution6169.longestNiceSubarray(nums));
    }
}
