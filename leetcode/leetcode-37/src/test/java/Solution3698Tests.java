import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3698Tests {
    private final Solution3698 solution3698 = new Solution3698();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2};
        long expected = 2;
        Assertions.assertEquals(expected, solution3698.splitArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3698.splitArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 1, 2};
        long expected = -1;
        Assertions.assertEquals(expected, solution3698.splitArray(nums));
    }
}