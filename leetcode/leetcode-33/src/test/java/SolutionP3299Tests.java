import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3299Tests {
    private final SolutionP3299 solutionP3299 = new SolutionP3299();

    @Test
    public void example1() {
        int[] nums = {1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3299.getSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 3};
        int expected = 31;
        Assertions.assertEquals(expected, solutionP3299.getSum(nums));
    }
}