import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100123Tests {
    private final Solution100123 solution100123 = new Solution100123();

    @Test
    public void example1() {
        int[] nums = {1, 2, 6, 4};
        long k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution100123.maxFrequencyScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 4, 2, 4};
        long k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution100123.maxFrequencyScore(nums, k));
    }
}