import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4072Tests {
    private final Solution4072 solution4072 = new Solution4072();

    @Test
    public void example1() {
        int[] nums = {5, -5, 1};
        long expected = 11;
        Assertions.assertEquals(expected, solution4072.maxAlternatingSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, -5, -100};
        long expected = 110;
        Assertions.assertEquals(expected, solution4072.maxAlternatingSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 7};
        long expected = 7;
        Assertions.assertEquals(expected, solution4072.maxAlternatingSum(nums));
    }
}
