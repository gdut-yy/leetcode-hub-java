import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4032Tests {
    private final Solution4032 solution4032 = new Solution4032();

    @Test
    public void example1() {
        int[] nums = {7, 6, 10, 12, 11};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution4032.longestSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6, 9, 18};
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution4032.longestSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {6, 10, 15};
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution4032.longestSubarray(nums, k));
    }
}