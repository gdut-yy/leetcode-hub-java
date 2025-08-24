import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3644Tests {
    private final Solution3644 solution3644 = new Solution3644();

    @Test
    public void example1() {
        int[] nums = {0, 3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3644.sortPermutation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3644.sortPermutation(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution3644.sortPermutation(nums));
    }
}