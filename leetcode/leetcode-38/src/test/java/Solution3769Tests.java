import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3769Tests {
    private final Solution3769 solution3769 = new Solution3769();

    @Test
    public void example1() {
        int[] nums = {4, 5, 4};
        int[] expected = {4, 4, 5};
        Assertions.assertArrayEquals(expected, solution3769.sortByReflection(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 6, 5, 8};
        int[] expected = {8, 3, 6, 5};
        Assertions.assertArrayEquals(expected, solution3769.sortByReflection(nums));
    }
}