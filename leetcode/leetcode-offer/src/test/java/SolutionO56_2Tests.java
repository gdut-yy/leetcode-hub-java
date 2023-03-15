import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO56_2Tests {
    private final SolutionO56_2 solutionO56_2 = new SolutionO56_2();

    @Test
    public void example1() {
        int[] nums = {3, 4, 3, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solutionO56_2.singleNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solutionO56_2.singleNumber(nums));
    }
}
