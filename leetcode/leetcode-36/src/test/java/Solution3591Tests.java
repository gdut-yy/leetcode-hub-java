import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3591Tests {
    private final Solution3591 solution3591 = new Solution3591();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 4};
        Assertions.assertTrue(solution3591.checkPrimeFrequency(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertFalse(solution3591.checkPrimeFrequency(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 2, 4, 4};
        Assertions.assertTrue(solution3591.checkPrimeFrequency(nums));
    }
}