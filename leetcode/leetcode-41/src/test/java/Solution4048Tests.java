import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4048Tests {
    private final Solution4048 solution4048 = new Solution4048();

    @Test
    public void example1() {
        int[] nums = {1, 8, 1, 5, 1, 5, 8, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution4048.countSpecialIntegers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {8, 8, 8, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution4048.countSpecialIntegers(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8, 6, 6, 8, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution4048.countSpecialIntegers(nums));
    }
}