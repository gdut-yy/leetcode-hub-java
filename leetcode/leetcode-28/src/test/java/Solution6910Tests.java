import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6910Tests {
    private final Solution6910 solution6910 = new Solution6910();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution6910.numberOfGoodSubarraySplits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution6910.numberOfGoodSubarraySplits(nums));
    }
}