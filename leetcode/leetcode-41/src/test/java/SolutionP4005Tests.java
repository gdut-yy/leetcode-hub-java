import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4005Tests {
    private final SolutionP4005 solutionP4005 = new SolutionP4005();

    @Test
    public void example1() {
        int[] nums = {6, 12, 8};
        long expected = 3;
        Assertions.assertEquals(expected, solutionP4005.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 15, 20};
        long expected = 2;
        Assertions.assertEquals(expected, solutionP4005.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 7, 7};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP4005.minOperations(nums));
    }
}
