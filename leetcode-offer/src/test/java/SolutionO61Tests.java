import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO61Tests {
    private final SolutionO61 solutionO61 = new SolutionO61();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solutionO61.isStraight(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 2, 5};
        Assertions.assertTrue(solutionO61.isStraight(nums));
    }
}
