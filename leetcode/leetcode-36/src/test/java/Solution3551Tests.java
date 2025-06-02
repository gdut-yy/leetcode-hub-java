import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3551Tests {
    private final Solution3551 solution3551 = new Solution3551();

    @Test
    public void example1() {
        int[] nums = {37, 100};
        int expected = 1;
        Assertions.assertEquals(expected, solution3551.minSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {22, 14, 33, 7};
        int expected = 0;
        Assertions.assertEquals(expected, solution3551.minSwaps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {18, 43, 34, 16};
        int expected = 2;
        Assertions.assertEquals(expected, solution3551.minSwaps(nums));
    }
}