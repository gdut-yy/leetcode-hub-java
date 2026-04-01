import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3854Tests {
    private final Solution3854 solution3854 = new Solution3854();

    @Test
    public void example1() {
        int[] nums = {-2, -3, 1, 4};
        int[] expected = {2, 6};
        Assertions.assertArrayEquals(expected, solution3854.makeParityAlternating(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 2, -2};
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution3854.makeParityAlternating(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution3854.makeParityAlternating(nums));
    }
}