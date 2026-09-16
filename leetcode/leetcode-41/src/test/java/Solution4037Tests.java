import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4037Tests {
    private final Solution4037 solution4037 = new Solution4037();

    @Test
    public void example1() {
        int[] nums = {10, 30, 15, 10};
        int expected = 2;
        Assertions.assertEquals(expected, solution4037.maxValidSplits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 10, 14};
        int expected = 1;
        Assertions.assertEquals(expected, solution4037.maxValidSplits(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution4037.maxValidSplits(nums));
    }
}