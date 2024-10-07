import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR183Tests {
    private final SolutionLCR183 solutionLCR183 = new SolutionLCR183();

    @Test
    public void example1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solutionLCR183.maxAltitude(nums, k));
    }

    // 补充用例
    @Test
    public void example2() {
        int[] nums = {};
        int k = 0;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solutionLCR183.maxAltitude(nums, k));
    }
}
