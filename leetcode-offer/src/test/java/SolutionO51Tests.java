import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO51Tests {
    private final SolutionO51 solutionO51 = new SolutionO51();

    @Test
    public void example1() {
        int[] nums = {7, 5, 6, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solutionO51.reversePairs(nums));
    }
}
