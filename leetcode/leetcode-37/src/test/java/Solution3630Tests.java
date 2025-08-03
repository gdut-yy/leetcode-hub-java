import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3630Tests {
    private final Solution3630 solution3630 = new Solution3630();

    @Test
    public void example1() {
        int[] nums = {2, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution3630.maximizeXorAndXor(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 2};
        long expected = 6;
        Assertions.assertEquals(expected, solution3630.maximizeXorAndXor(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 6, 7};
        long expected = 15;
        Assertions.assertEquals(expected, solution3630.maximizeXorAndXor(nums));
    }
}