import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3717Tests {
    private final SolutionP3717 solutionP3717 = new SolutionP3717();

    @Test
    public void example1() {
        int[] nums = {3, 7, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3717.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3717.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3717.minOperations(nums));
    }
}