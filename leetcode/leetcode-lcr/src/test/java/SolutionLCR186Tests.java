import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR186Tests {
    private final SolutionLCR186 solutionLCR186 = new SolutionLCR186();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solutionLCR186.checkDynasty(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 2, 5};
        Assertions.assertTrue(solutionLCR186.checkDynasty(nums));
    }
}
