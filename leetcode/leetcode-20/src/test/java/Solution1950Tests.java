import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1950Tests {
    private final Solution1950 solution1950 = new Solution1950();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 4};
        int[] expected = {4, 2, 1, 0};
        Assertions.assertArrayEquals(expected, solution1950.findMaximums(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 50, 10};
        int[] expected = {50, 20, 10, 10};
        Assertions.assertArrayEquals(expected, solution1950.findMaximums(nums));
    }
}