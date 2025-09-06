import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3496Tests {
    private final SolutionP3496 solutionP3496 = new SolutionP3496();

    @Test
    public void example1() {
        int[] nums = {2, 4, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3496.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, -1, 4, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solutionP3496.maxScore(nums));
    }
}