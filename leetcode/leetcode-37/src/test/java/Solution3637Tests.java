import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3637Tests {
    private final Solution3637 solution3637 = new Solution3637();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 4, 2, 6};
        Assertions.assertTrue(solution3637.isTrionic(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 3};
        Assertions.assertFalse(solution3637.isTrionic(nums));
    }
}