import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100120Tests {
    private final Solution100120 solution100120 = new Solution100120();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution100120.maximumStrongPairXor(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 100};
        int expected = 0;
        Assertions.assertEquals(expected, solution100120.maximumStrongPairXor(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 6, 25, 30};
        int expected = 7;
        Assertions.assertEquals(expected, solution100120.maximumStrongPairXor(nums));
    }
}