import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionLCR179Tests {
    private final SolutionLCR179 solutionLCR179 = new SolutionLCR179();

    @Test
    public void example1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {2, 7};
        int[] actual = solutionLCR179.twoSum(nums, target);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        int[] expected = {10, 30};
        int[] actual = solutionLCR179.twoSum(nums, target);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
