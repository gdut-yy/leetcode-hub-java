import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4074Tests {
    private final Solution4074 solution4074 = new Solution4074();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution4074.maxProductPair(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {-3, -1, 4, 2};
        int target = 1;
        int[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, solution4074.maxProductPair(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3, 5};
        int target = 6;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution4074.maxProductPair(nums, target));
    }
}
