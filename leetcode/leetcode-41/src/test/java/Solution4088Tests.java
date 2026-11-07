import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4088Tests {
    private final Solution4088 solution4088 = new Solution4088();

    @Test
    public void example1() {
        int[] nums = {1, 5, 2, 4, 1, 3, 0};
        int expected = 9;
        Assertions.assertEquals(expected, solution4088.peakValleyDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-5, -6, -1, -2, 5, 3, 2};
        int expected = 12;
        Assertions.assertEquals(expected, solution4088.peakValleyDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {6, 5, 2, 5, 5, 3, 6};
        int expected = -5;
        Assertions.assertEquals(expected, solution4088.peakValleyDifference(nums));
    }
}
