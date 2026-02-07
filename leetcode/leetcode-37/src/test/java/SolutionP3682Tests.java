import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3682Tests {
    private final SolutionP3682 solutionP3682 = new SolutionP3682();

    @Test
    public void example1() {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 3, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3682.minimumSum(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {5, 1, 2};
        int[] nums2 = {2, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3682.minimumSum(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {6, 4};
        int[] nums2 = {7, 8};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3682.minimumSum(nums1, nums2));
    }
}