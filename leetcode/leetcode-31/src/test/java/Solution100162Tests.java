import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100162Tests {
    private final Solution100162 solution100162 = new Solution100162();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution100162.maxFrequencyElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution100162.maxFrequencyElements(nums));
    }
}