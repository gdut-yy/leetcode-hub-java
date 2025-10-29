import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3727Tests {
    private final Solution3727 solution3727 = new Solution3727();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        long expected = 12;
        Assertions.assertEquals(expected, solution3727.maxAlternatingSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, -1, 2, -2, 3, -3};
        long expected = 16;
        Assertions.assertEquals(expected, solution3727.maxAlternatingSum(nums));
    }
}