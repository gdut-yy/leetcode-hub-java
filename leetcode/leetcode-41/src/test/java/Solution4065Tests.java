import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4065Tests {
    private final Solution4065 solution4065 = new Solution4065();

    @Test
    public void example1() {
        int[] nums = {3, 1, 3, 2, 1, 3};
        int[] expected = {1, 2, 3, 1, 3, 3};
        Assertions.assertArrayEquals(expected, solution4065.rearrangeArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 7, 4, 4, 4};
        int[] expected = {4, 7, 4, 7, 4};
        Assertions.assertArrayEquals(expected, solution4065.rearrangeArray(nums));
    }
}
