import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3660Tests {
    private final Solution3660 solution3660 = new Solution3660();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int[] expected = {2, 2, 3};
        Assertions.assertArrayEquals(expected, solution3660.maxValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1};
        int[] expected = {3, 3, 3};
        Assertions.assertArrayEquals(expected, solution3660.maxValue(nums));
    }
}