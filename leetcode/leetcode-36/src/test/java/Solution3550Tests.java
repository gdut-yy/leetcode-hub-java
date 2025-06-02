import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3550Tests {
    private final Solution3550 solution3550 = new Solution3550();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3550.smallestIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 11};
        int expected = 1;
        Assertions.assertEquals(expected, solution3550.smallestIndex(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution3550.smallestIndex(nums));
    }
}