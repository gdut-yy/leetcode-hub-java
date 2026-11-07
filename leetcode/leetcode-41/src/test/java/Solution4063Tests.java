import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4063Tests {
    private final Solution4063 solution4063 = new Solution4063();

    @Test
    public void example1() {
        int[] nums = {4, 1, 2};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution4063.longestSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 3, 4};
        int k = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solution4063.longestSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 5};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution4063.longestSubarray(nums, k));
    }
}
