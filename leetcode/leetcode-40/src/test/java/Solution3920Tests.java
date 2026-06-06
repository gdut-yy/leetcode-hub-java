import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3920Tests {
    private final Solution3920 solution3920 = new Solution3920();

    @Test
    public void example1() {
        int[] nums = {0, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3920.maxFixedPoints(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3920.maxFixedPoints(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 0, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3920.maxFixedPoints(nums));
    }
}