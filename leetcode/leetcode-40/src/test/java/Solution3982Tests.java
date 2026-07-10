import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3982Tests {
    private final Solution3982 solution3982 = new Solution3982();

    @Test
    public void example1() {
        int[] nums = {5724, 111, 350};
        int expected = 6074;
        Assertions.assertEquals(expected, solution3982.maxDigitRange(nums));
    }

    @Test
    public void example2() {
        int[] nums = {90,900};
        int expected = 990;
        Assertions.assertEquals(expected, solution3982.maxDigitRange(nums));
    }
}