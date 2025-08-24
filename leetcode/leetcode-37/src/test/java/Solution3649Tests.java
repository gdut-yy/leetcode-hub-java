import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3649Tests {
    private final Solution3649 solution3649 = new Solution3649();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 3};
        long expected = 2;
        Assertions.assertEquals(expected, solution3649.perfectPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, 2, -1, 4};
        long expected = 4;
        Assertions.assertEquals(expected, solution3649.perfectPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 10, 100, 1000};
        long expected = 0;
        Assertions.assertEquals(expected, solution3649.perfectPairs(nums));
    }
}