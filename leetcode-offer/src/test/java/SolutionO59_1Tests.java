import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO59_1Tests {
    private final SolutionO59_1 solutionO59_1 = new SolutionO59_1();

    @Test
    public void example1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solutionO59_1.maxSlidingWindow(nums, k));
    }
}
