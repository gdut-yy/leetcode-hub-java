import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6258Tests {
    private final Solution6258 solution6258 = new Solution6258();

    @Test
    public void example1() {
        int[] nums = {4, 3, 6, 16, 8, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution6258.longestSquareStreak(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 6, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution6258.longestSquareStreak(nums));
    }
}
