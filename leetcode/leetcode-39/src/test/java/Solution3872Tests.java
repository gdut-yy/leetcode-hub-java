import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3872Tests {
    private final Solution3872 solution3872 = new Solution3872();

    @Test
    public void example1() {
        int[] nums = {9, 7, 5, 10, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solution3872.longestArithmetic(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 6, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution3872.longestArithmetic(nums));
    }
}