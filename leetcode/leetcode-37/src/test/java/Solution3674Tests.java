import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3674Tests {
    private final Solution3674 solution3674 = new Solution3674();

    @Test
    public void example1() {
        int[] nums = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3674.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution3674.minOperations(nums));
    }
}