import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4055Tests {
    private final Solution4055 solution4055 = new Solution4055();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4, 2, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution4055.shadowPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 7, 8, 9};
        int expected = 3;
        Assertions.assertEquals(expected, solution4055.shadowPairs(nums));
    }
}