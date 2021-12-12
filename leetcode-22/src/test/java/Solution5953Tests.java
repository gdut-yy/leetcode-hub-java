import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5953Tests {
    private final Solution5953 solution5953 = new Solution5953();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution5953.subArrayRanges(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution5953.subArrayRanges(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, -2, -3, 4, 1};
        long expected = 59;
        Assertions.assertEquals(expected, solution5953.subArrayRanges(nums));
    }
}
