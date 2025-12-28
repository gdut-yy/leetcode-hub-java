import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3766Tests {
    private final Solution3766 solution3766 = new Solution3766();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4};
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, solution3766.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 7, 12};
        int[] expected = {1, 0, 3};
        Assertions.assertArrayEquals(expected, solution3766.minOperations(nums));
    }
}