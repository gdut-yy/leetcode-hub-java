import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3587Tests {
    private final Solution3587 solution3587 = new Solution3587();

    @Test
    public void example1() {
        int[] nums = {2, 4, 6, 5, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution3587.minSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 5, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution3587.minSwaps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution3587.minSwaps(nums));
    }

    @Test
    public void example4() {
        int[] nums = {4, 5, 6, 8};
        int expected = -1;
        Assertions.assertEquals(expected, solution3587.minSwaps(nums));
    }
}