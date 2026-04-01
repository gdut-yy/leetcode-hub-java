import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3862Tests {
    private final Solution3862 solution3862 = new Solution3862();

    @Test
    public void example1() {
        int[] nums = {2, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3862.smallestBalancedIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 8, 2, 2, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3862.smallestBalancedIndex(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = -1;
        Assertions.assertEquals(expected, solution3862.smallestBalancedIndex(nums));
    }
}