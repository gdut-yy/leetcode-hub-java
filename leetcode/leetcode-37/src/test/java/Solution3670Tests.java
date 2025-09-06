import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3670Tests {
    private final Solution3670 solution3670 = new Solution3670();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        long expected = 12;
        Assertions.assertEquals(expected, solution3670.maxProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 4};
        long expected = 0;
        Assertions.assertEquals(expected, solution3670.maxProduct(nums));
    }

    @Test
    public void example3() {
        int[] nums = {64, 8, 32};
        long expected = 2048;
        Assertions.assertEquals(expected, solution3670.maxProduct(nums));
    }
}