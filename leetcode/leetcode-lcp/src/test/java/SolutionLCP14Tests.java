import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP14Tests {
    private final SolutionLCP14 solutionLCP14 = new SolutionLCP14();

    @Test
    public void example1() {
        int[] nums = {2, 3, 3, 2, 3, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP14.splitArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP14.splitArray(nums));
    }
}