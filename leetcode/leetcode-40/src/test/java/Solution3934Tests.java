import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3934Tests {
    private final Solution3934 solution3934 = new Solution3934();

    @Test
    public void example1() {
        int[] nums = {3, 3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3934.smallestUniqueSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 2, 3, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3934.smallestUniqueSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3934.smallestUniqueSubarray(nums));
    }
}