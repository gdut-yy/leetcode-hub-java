import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3732Tests {
    private final Solution3732 solution3732 = new Solution3732();

    @Test
    public void example1() {
        int[] nums = {-5, 7, 0};
        long expected = 3500000;
        Assertions.assertEquals(expected, solution3732.maxProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-4, -2, -1, -3};
        long expected = 1200000;
        Assertions.assertEquals(expected, solution3732.maxProduct(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 10, 0};
        long expected = 0;
        Assertions.assertEquals(expected, solution3732.maxProduct(nums));
    }
}