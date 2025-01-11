import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3379Tests {
    private final Solution3379 solution3379 = new Solution3379();

    @Test
    public void example1() {
        int[] nums = {3, -2, 1, 1};
        int[] expected = {1, 1, 1, 3};
        Assertions.assertArrayEquals(expected, solution3379.constructTransformedArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 4, -1};
        int[] expected = {-1, -1, 4};
        Assertions.assertArrayEquals(expected, solution3379.constructTransformedArray(nums));
    }
}