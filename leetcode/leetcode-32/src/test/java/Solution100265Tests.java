import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100265Tests {
    private final Solution100265 solution100265 = new Solution100265();

    @Test
    public void example1() {
        int[] nums = {4, 2, 9, 5, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution100265.maximumPrimeDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 8, 2, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution100265.maximumPrimeDifference(nums));
    }
}