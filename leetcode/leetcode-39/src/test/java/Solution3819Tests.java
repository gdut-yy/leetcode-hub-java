import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3819Tests {
    private final Solution3819 solution3819 = new Solution3819();

    @Test
    public void example1() {
        int[] nums = {1, -2, 3, -4};
        int k = 3;
        int[] expected = {3, -2, 1, -4};
        Assertions.assertArrayEquals(expected, solution3819.rotateElements(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-3, -2, 7};
        int k = 1;
        int[] expected = {-3, -2, 7};
        Assertions.assertArrayEquals(expected, solution3819.rotateElements(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 4, -9, 6};
        int k = 2;
        int[] expected = {6, 5, -9, 4};
        Assertions.assertArrayEquals(expected, solution3819.rotateElements(nums, k));
    }
}