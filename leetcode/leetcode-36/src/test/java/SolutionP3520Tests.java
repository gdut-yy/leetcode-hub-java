import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3520Tests {
    private final SolutionP3520 solutionP3520 = new SolutionP3520();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 3, 2, 1};
        int k = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3520.minThreshold(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 9, 9, 9, 1};
        int k = 4;
        int expected = 8;
        Assertions.assertEquals(expected, solutionP3520.minThreshold(nums, k));
    }
}