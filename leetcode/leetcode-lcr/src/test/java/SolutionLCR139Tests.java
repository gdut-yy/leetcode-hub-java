import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR139Tests {
    private final SolutionLCR139 solutionLCR139 = new SolutionLCR139();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {1, 3, 2, 4};
        Assertions.assertArrayEquals(expected, solutionLCR139.trainingPlan(nums));
    }
}
