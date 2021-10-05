import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO53_2Tests {
    private final SolutionO53_2 solutionO53_2 = new SolutionO53_2();

    @Test
    public void example1() {
        int[] nums = {0, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionO53_2.missingNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int expected = 8;
        Assertions.assertEquals(expected, solutionO53_2.missingNumber(nums));
    }
}
