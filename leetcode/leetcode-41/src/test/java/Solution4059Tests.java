import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4059Tests {
    private final Solution4059 solution4059 = new Solution4059();

    @Test
    public void example1() {
        int[] nums = {7, 5};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution4059.largestPower(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 7};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solution4059.largestPower(nums));
    }
}
