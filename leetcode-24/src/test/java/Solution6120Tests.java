import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6120Tests {
    private final Solution6120 solution6120 = new Solution6120();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, solution6120.numberOfPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1};
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution6120.numberOfPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution6120.numberOfPairs(nums));
    }
}
