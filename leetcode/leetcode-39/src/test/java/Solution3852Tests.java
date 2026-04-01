import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3852Tests {
    private final Solution3852 solution3852 = new Solution3852();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 3, 4};
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution3852.minDistinctFreqPair(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3852.minDistinctFreqPair(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3852.minDistinctFreqPair(nums));
    }
}