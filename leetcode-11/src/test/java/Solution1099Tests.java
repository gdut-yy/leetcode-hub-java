import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1099Tests {
    private final Solution1099 solution1099 = new Solution1099();

    @Test
    public void example1() {
        int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;
        int expected = 58;
        Assertions.assertEquals(expected, solution1099.twoSumLessThanK(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 30};
        int k = 15;
        int expected = -1;
        Assertions.assertEquals(expected, solution1099.twoSumLessThanK(nums, k));
    }
}
