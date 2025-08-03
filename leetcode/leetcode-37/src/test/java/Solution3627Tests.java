import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3627Tests {
    private final Solution3627 solution3627 = new Solution3627();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 2, 1, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution3627.maximumMedianSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 10, 10, 10, 10};
        long expected = 20;
        Assertions.assertEquals(expected, solution3627.maximumMedianSum(nums));
    }
}