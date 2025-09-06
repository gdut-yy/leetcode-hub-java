import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3353Tests {
    private final SolutionP3353 solutionP3353 = new SolutionP3353();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3353.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 10, 10};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3353.minOperations(nums));
    }
}