import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100074Tests {
    private final Solution100074 solution100074 = new Solution100074();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int expected = 15;
        Assertions.assertEquals(expected, solution100074.sumCounts(nums));
        Assertions.assertEquals(expected, solution100074.sumCounts2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution100074.sumCounts(nums));
        Assertions.assertEquals(expected, solution100074.sumCounts2(nums));
    }
}