import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP30Tests {
    private final SolutionLCP30 solutionLCP30 = new SolutionLCP30();

    @Test
    public void example1() {
        int[] nums = {100, 100, 100, -250, -60, -140, -50, -50, 100, 150};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP30.magicTower(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-200, -300, 400, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP30.magicTower(nums));
    }
}
