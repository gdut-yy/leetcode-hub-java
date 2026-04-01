import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3867Tests {
    private final Solution3867 solution3867 = new Solution3867();

    @Test
    public void example1() {
        int[] nums = {2, 6, 4};
        long expected = 2;
        Assertions.assertEquals(expected, solution3867.gcdSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 6, 2, 8};
        long expected = 5;
        Assertions.assertEquals(expected, solution3867.gcdSum(nums));
    }
}