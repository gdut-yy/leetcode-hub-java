import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100243Tests {
    private final Solution100243 solution100243 = new Solution100243();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solution100243.resultArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 3, 8};
        int[] expected = {5, 3, 4, 8};
        Assertions.assertArrayEquals(expected, solution100243.resultArray(nums));
    }
}