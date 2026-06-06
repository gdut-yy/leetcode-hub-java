import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3896Tests {
    private final Solution3896 solution3896 = new Solution3896();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution3896.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 7, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution3896.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3896.minOperations(nums));
    }
}