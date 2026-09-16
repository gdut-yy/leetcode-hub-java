import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4054Tests {
    private final Solution4054 solution4054 = new Solution4054();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4, 1, 5};
        long expected = 3;
        Assertions.assertEquals(expected, solution4054.shadowPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 7, 6, 6, 7};
        long expected = 4;
        Assertions.assertEquals(expected, solution4054.shadowPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        long expected = 6;
        Assertions.assertEquals(expected, solution4054.shadowPairs(nums));
    }
}