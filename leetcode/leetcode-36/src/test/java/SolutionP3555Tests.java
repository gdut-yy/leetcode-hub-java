import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3555Tests {
    private final SolutionP3555.V1 solutionP3555_v1 = new SolutionP3555.V1();
    private final SolutionP3555.V2 solutionP3555_v2 = new SolutionP3555.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4, 5};
        int k = 3;
        int[] expected = {2, 2, 0};
        Assertions.assertArrayEquals(expected, solutionP3555_v1.minSubarraySort(nums, k));
        Assertions.assertArrayEquals(expected, solutionP3555_v2.minSubarraySort(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 3, 2, 1};
        int k = 4;
        int[] expected = {4, 4};
        Assertions.assertArrayEquals(expected, solutionP3555_v1.minSubarraySort(nums, k));
        Assertions.assertArrayEquals(expected, solutionP3555_v2.minSubarraySort(nums, k));
    }
}