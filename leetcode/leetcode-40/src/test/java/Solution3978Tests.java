import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3978Tests {
    private final Solution3978 solution3978 = new Solution3978();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        Assertions.assertTrue(solution3978.isMiddleElementUnique(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2};
        Assertions.assertFalse(solution3978.isMiddleElementUnique(nums));
    }
}