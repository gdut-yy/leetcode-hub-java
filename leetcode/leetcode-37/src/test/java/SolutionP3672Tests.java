import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3672Tests {
    private final SolutionP3672 solutionP3672 = new SolutionP3672();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3};
        int k = 3;
        long expected = 8;
        Assertions.assertEquals(expected, solutionP3672.modeWeight(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2};
        int k = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP3672.modeWeight(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 4, 3};
        int k = 3;
        long expected = 14;
        Assertions.assertEquals(expected, solutionP3672.modeWeight(nums, k));
    }
}