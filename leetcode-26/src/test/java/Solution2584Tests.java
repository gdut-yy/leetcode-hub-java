import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2584Tests {
    private final Solution2584 solution2584 = new Solution2584();

    @Test
    public void example1() {
        int[] nums = {4, 7, 8, 15, 3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution2584.findValidSplit(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 7, 15, 8, 3, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solution2584.findValidSplit(nums));
    }
}