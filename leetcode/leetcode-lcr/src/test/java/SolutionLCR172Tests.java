import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR172Tests {
    private final SolutionLCR172 solutionLCR172 = new SolutionLCR172();

    @Test
    public void example1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR172.countTarget(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCR172.countTarget(nums, target));
    }
}
