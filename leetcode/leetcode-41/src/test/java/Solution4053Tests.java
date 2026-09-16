import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4053Tests {
    private final Solution4053 solution4053 = new Solution4053();

    @Test
    public void example1() {
        int[] nums = {10, 12, 14, 16};
        long expected = 9;
        Assertions.assertEquals(expected, solution4053.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 10, 11, 10};
        long expected = 2;
        Assertions.assertEquals(expected, solution4053.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {125};
        long expected = 2;
        Assertions.assertEquals(expected, solution4053.minOperations(nums));
    }
}