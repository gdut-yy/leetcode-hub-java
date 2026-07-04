import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3925Tests {
    private final Solution3925 solution3925 = new Solution3925();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 2, 3, 3, 2, 1};
        Assertions.assertArrayEquals(expected, solution3925.concatWithReverse(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution3925.concatWithReverse(nums));
    }
}