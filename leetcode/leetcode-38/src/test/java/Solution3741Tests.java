import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3741Tests {
    private final Solution3741 solution3741 = new Solution3741();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 1, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution3741.minimumDistance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 3, 2, 1, 2};
        int expected = 8;
        Assertions.assertEquals(expected, solution3741.minimumDistance(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = -1;
        Assertions.assertEquals(expected, solution3741.minimumDistance(nums));
    }
}