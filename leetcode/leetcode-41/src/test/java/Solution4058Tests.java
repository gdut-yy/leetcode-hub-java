import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4058Tests {
    private final Solution4058 solution4058 = new Solution4058();

    @Test
    public void example1() {
        int[] nums = {1, 5, 2};
        long expected = 6;
        Assertions.assertEquals(expected, solution4058.maxValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 4, 3};
        long expected = 7;
        Assertions.assertEquals(expected, solution4058.maxValue(nums));
    }

    @Test
    public void example3() {
        int[] nums = {9, 7};
        long expected = 2;
        Assertions.assertEquals(expected, solution4058.maxValue(nums));
    }
}
