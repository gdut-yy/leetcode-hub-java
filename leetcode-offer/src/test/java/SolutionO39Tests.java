import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO39Tests {
    private final SolutionO39 solutionO39 = new SolutionO39();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionO39.majorityElement(nums));
        Assertions.assertEquals(expected, solutionO39.majorityElement2(nums));
    }
}
