import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3467Tests {
    private final Solution3467 solution3467 = new Solution3467();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 1};
        int[] expected = {0, 0, 1, 1};
        Assertions.assertArrayEquals(expected, solution3467.transformArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 1, 4, 2};
        int[] expected = {0, 0, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3467.transformArray(nums));
    }
}