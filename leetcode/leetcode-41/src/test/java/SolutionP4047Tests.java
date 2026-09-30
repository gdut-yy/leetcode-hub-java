import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4047Tests {
    private final SolutionP4047 solutionP4047 = new SolutionP4047();

    @Test
    public void example1() {
        int[] nums = {8, 1, 4, 8, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP4047.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP4047.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP4047.minOperations(nums));
    }
}
