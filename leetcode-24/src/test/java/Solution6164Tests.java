import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6164Tests {
    private final Solution6164 solution6164 = new Solution6164();

    @Test
    public void example1() {
        int[] nums = {18, 43, 36, 13, 7};
        int expected = 54;
        Assertions.assertEquals(expected, solution6164.maximumSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 12, 19, 14};
        int expected = -1;
        Assertions.assertEquals(expected, solution6164.maximumSum(nums));
    }
}
