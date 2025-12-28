import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3788Tests {
    private final Solution3788 solution3788 = new Solution3788();

    @Test
    public void example1() {
        int[] nums = {10, -1, 3, -4, -5};
        long expected = 17;
        Assertions.assertEquals(expected, solution3788.maximumScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-7, -5, 3};
        long expected = -2;
        Assertions.assertEquals(expected, solution3788.maximumScore(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1};
        long expected = 0;
        Assertions.assertEquals(expected, solution3788.maximumScore(nums));
    }
}