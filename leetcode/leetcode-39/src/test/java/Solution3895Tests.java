import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3895Tests {
    private final Solution3895 solution3895 = new Solution3895();

    @Test
    public void example1() {
        int[] nums = {12, 54, 32, 22};
        int digit = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3895.countDigitOccurrences(nums, digit));
    }

    @Test
    public void example2() {
        int[] nums = {1, 34, 7};
        int digit = 9;
        int expected = 0;
        Assertions.assertEquals(expected, solution3895.countDigitOccurrences(nums, digit));
    }
}