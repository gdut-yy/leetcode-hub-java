import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3284Tests {
    private final SolutionP3284 solutionP3284 = new SolutionP3284();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 20;
        Assertions.assertEquals(expected, solutionP3284.getSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 7};
        int expected = 16;
        Assertions.assertEquals(expected, solutionP3284.getSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 6, 1, 2};
        int expected = 32;
        Assertions.assertEquals(expected, solutionP3284.getSum(nums));
    }
}