import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4095Tests {
    private final Solution4095 solution4095 = new Solution4095();

    @Test
    public void example1() {
        int[] nums = {5, 8, 8, 2, 2, 2};
        int expected = 9;
        Assertions.assertEquals(expected, solution4095.countStaircase(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 6, 9, 9};
        int expected = 5;
        Assertions.assertEquals(expected, solution4095.countStaircase(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 4, 4, 3, 4};
        int expected = 8;
        Assertions.assertEquals(expected, solution4095.countStaircase(nums));
    }
}
