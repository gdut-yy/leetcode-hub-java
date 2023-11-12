import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100124Tests {
    private final Solution100124 solution100124 = new Solution100124();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution100124.maximumStrongPairXor(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 100};
        int expected = 0;
        Assertions.assertEquals(expected, solution100124.maximumStrongPairXor(nums));
    }

    @Test
    public void example3() {
        int[] nums = {500, 520, 2500, 3000};
        int expected = 1020;
        Assertions.assertEquals(expected, solution100124.maximumStrongPairXor(nums));
    }
}