import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6416Tests {
    private final Solution6416 solution6416 = new Solution6416();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {-3, -1, 1, 3, 5};
        Assertions.assertArrayEquals(expected, solution6416.distinctDifferenceArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 3, 4, 2};
        int[] expected = {-2, -1, 0, 2, 3};
        Assertions.assertArrayEquals(expected, solution6416.distinctDifferenceArray(nums));
    }
}