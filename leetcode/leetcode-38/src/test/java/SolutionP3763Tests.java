import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3763Tests {
    private final SolutionP3763 solutionP3763 = new SolutionP3763();

    @Test
    public void example1() {
        int[] nums = {1, 10, 4, 2, 1, 6};
        int[] threshold = {5, 1, 5, 5, 2, 2};
        long expected = 17;
        Assertions.assertEquals(expected, solutionP3763.maxSum(nums, threshold));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 5, 2, 3};
        int[] threshold = {3, 3, 2, 3, 3};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP3763.maxSum(nums, threshold));
    }

    @Test
    public void example3() {
        int[] nums = {2, 6, 10, 13};
        int[] threshold = {2, 1, 1, 1};
        long expected = 31;
        Assertions.assertEquals(expected, solutionP3763.maxSum(nums, threshold));
    }
}