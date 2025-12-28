import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3768Tests {
    private final Solution3768 solution3768 = new Solution3768();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2, 5, 4};
        int k = 3;
        long expected = 0;
        Assertions.assertEquals(expected, solution3768.minInversionCount(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 3, 2, 1};
        int k = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solution3768.minInversionCount(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, 1};
        int k = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution3768.minInversionCount(nums, k));
    }
}