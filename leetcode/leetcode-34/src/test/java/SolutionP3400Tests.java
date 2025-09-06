import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3400Tests {
    private final SolutionP3400 solutionP3400 = new SolutionP3400();

    @Test
    public void example1() {
        int[] nums1 = {3, 1, 2, 3, 1, 2};
        int[] nums2 = {1, 2, 3, 1, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3400.maximumMatchingIndices(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 4, 2, 5, 3, 1};
        int[] nums2 = {2, 3, 1, 2, 4, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3400.maximumMatchingIndices(nums1, nums2));
    }
}