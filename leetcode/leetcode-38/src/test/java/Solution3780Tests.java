import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3780Tests {
    private final Solution3780 solution3780 = new Solution3780();

    @Test
    public void example1() {
        int[] nums = {4, 2, 3, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution3780.maximumSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution3780.maximumSum(nums));
    }
}