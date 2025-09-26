import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3688Tests {
    private final Solution3688 solution3688 = new Solution3688();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int expected = 6;
        Assertions.assertEquals(expected, solution3688.evenNumberBitwiseORs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 9, 11};
        int expected = 0;
        Assertions.assertEquals(expected, solution3688.evenNumberBitwiseORs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 8, 16};
        int expected = 24;
        Assertions.assertEquals(expected, solution3688.evenNumberBitwiseORs(nums));
    }
}