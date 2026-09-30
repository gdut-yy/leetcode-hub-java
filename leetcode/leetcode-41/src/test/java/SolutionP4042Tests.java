import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4042Tests {
    private final SolutionP4042 solutionP4042 = new SolutionP4042();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1};
        int k = 2;
        int l0 = 1;
        int r0 = 2;
        int q = 2;
        boolean[] expected = {false, true};
        Assertions.assertArrayEquals(expected, solutionP4042.validSubarrays(nums, k, l0, r0, q));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 3, 4};
        int k = 1;
        int l0 = 2;
        int r0 = 3;
        int q = 2;
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, solutionP4042.validSubarrays(nums, k, l0, r0, q));
    }
}
