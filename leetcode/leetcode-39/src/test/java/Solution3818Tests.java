import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3818Tests {
    private final Solution3818 solution3818 = new Solution3818();

    @Test
    public void example1() {
        int[] nums = {1, -1, 2, 3, 3, 4, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution3818.minimumPrefixLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, -2, -5};
        int expected = 3;
        Assertions.assertEquals(expected, solution3818.minimumPrefixLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3818.minimumPrefixLength(nums));
    }
}