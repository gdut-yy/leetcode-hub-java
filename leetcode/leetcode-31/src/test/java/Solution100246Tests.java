import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100246Tests {
    private final Solution100246 solution100246 = new Solution100246();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 3};
        int[] expected = {2, 3, 1, 3};
        Assertions.assertArrayEquals(expected, solution100246.resultArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 14, 3, 1, 2};
        int[] expected = {5, 3, 1, 2, 14};
        Assertions.assertArrayEquals(expected, solution100246.resultArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3};
        Assertions.assertArrayEquals(expected, solution100246.resultArray(nums));
    }
}