import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3395Tests {
    private final Solution3395 solution3395 = new Solution3395();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 1, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution3395.subsequencesWithMiddleMode(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution3395.subsequencesWithMiddleMode(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution3395.subsequencesWithMiddleMode(nums));
    }
}