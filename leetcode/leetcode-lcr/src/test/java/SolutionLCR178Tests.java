import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR178Tests {
    private final SolutionLCR178 solutionLCR178 = new SolutionLCR178();

    @Test
    public void example1() {
        int[] nums = {3, 4, 3, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCR178.trainingPlan(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR178.trainingPlan(nums));
    }
}
