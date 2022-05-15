import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6067Tests {
    private final Solution6067 solution6067 = new Solution6067();

    @Test
    public void example1() {
        int[] nums = {10, 4, -8, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution6067.waysToSplitArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution6067.waysToSplitArray(nums));
    }
}
