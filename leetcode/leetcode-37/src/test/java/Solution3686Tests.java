import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3686Tests {
    private final Solution3686 solution3686 = new Solution3686();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution3686.countStableSubsequences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 2};
        int expected = 14;
        Assertions.assertEquals(expected, solution3686.countStableSubsequences(nums));
    }
}