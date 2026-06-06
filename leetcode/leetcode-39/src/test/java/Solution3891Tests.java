import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3891Tests {
    private final Solution3891 solution3891 = new Solution3891();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2};
        long expected = 1;
        Assertions.assertEquals(expected, solution3891.minIncrease(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 1, 3};
        long expected = 2;
        Assertions.assertEquals(expected, solution3891.minIncrease(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 2, 1, 4, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3891.minIncrease(nums));
    }
}