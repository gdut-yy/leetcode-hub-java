import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3779Tests {
    private final Solution3779 solution3779 = new Solution3779();

    @Test
    public void example1() {
        int[] nums = {3, 8, 3, 6, 5, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution3779.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3779.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 5, 1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3779.minOperations(nums));
    }
}