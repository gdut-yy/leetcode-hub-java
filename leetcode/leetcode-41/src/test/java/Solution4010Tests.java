import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4010Tests {
    private final Solution4010 solution4010 = new Solution4010();

    @Test
    public void example1() {
        int[] nums = {2, 3, 5};
        long expected = 15;
        Assertions.assertEquals(expected, solution4010.maxPairStrength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6, 8};
        long expected = 12;
        Assertions.assertEquals(expected, solution4010.maxPairStrength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3};
        long expected = 1;
        Assertions.assertEquals(expected, solution4010.maxPairStrength(nums));
    }
}