import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4109Tests {
    private final Solution4109 solution4109 = new Solution4109();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3};
        int[] target = {2, 2, 3, 2, 1, 3, 2, 2};
        int[] expected = {1, 1, 0, 0, 0, 1};
        Assertions.assertArrayEquals(expected, solution4109.countSuffix(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 5};
        int[] target = {5, 6, 5, 5, 6, 5};
        int[] expected = {2, 1, 0, 2};
        Assertions.assertArrayEquals(expected, solution4109.countSuffix(nums, target));
    }
}
