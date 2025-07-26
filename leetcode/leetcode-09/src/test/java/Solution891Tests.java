import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution891Tests {
    private final Solution891 solution891 = new Solution891();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution891.sumSubseqWidths(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2};
        int expected = 0;
        Assertions.assertEquals(expected, solution891.sumSubseqWidths(nums));
    }
}