import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3948Tests {
    private final Solution3948 solution3948 = new Solution3948();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0};
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution3948.maximumMEX(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 2};
        int[] expected = {3};
        Assertions.assertArrayEquals(expected, solution3948.maximumMEX(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 1};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution3948.maximumMEX(nums));
    }
}