import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3431Tests {
    private final SolutionP3431 solutionP3431 = new SolutionP3431();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 3, 2};
        int[] locked = {1, 0, 1, 1, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3431.minUnlockedIndices(nums, locked));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 1, 3, 2, 2};
        int[] locked = {1, 0, 1, 1, 0, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3431.minUnlockedIndices(nums, locked));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 2, 3, 2, 1};
        int[] locked = {0, 0, 0, 0, 0, 0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3431.minUnlockedIndices(nums, locked));
    }
}