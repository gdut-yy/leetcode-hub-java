import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR128Tests {
    private final SolutionLCR128 solutionLCR128 = new SolutionLCR128();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR128.stockManagement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCR128.stockManagement(nums));
    }
}
