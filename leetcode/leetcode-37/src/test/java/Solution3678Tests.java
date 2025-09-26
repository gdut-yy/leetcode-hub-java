import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3678Tests {
    private final Solution3678 solution3678 = new Solution3678();

    @Test
    public void example1() {
        int[] nums = {3, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution3678.smallestAbsent(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3678.smallestAbsent(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, -1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3678.smallestAbsent(nums));
    }
}