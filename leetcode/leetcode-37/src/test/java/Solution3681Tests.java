import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3681Tests {
    private final Solution3681 solution3681 = new Solution3681();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3681.maxXorSubsequences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution3681.maxXorSubsequences(nums));
    }
}