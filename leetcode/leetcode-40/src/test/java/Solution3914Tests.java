import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3914Tests {
    private final Solution3914 solution3914 = new Solution3914();

    @Test
    public void example1() {
        int[] nums = {3, 3, 2, 1};
        long expected = 2;
        Assertions.assertEquals(expected, solution3914.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 1, 2, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3914.minOperations(nums));
    }
}