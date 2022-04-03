import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6034Tests {
    private final Solution6034 solution6034 = new Solution6034();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution6034.triangularSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5};
        int expected = 5;
        Assertions.assertEquals(expected, solution6034.triangularSum(nums));
    }
}
