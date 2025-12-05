import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3761Tests {
    private final Solution3761 solution3761 = new Solution3761();

    @Test
    public void example1() {
        int[] nums = {12, 21, 45, 33, 54};
        int expected = 1;
        Assertions.assertEquals(expected, solution3761.minMirrorPairDistance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {120, 21};
        int expected = 1;
        Assertions.assertEquals(expected, solution3761.minMirrorPairDistance(nums));
    }

    @Test
    public void example3() {
        int[] nums = {21, 120};
        int expected = -1;
        Assertions.assertEquals(expected, solution3761.minMirrorPairDistance(nums));
    }
}