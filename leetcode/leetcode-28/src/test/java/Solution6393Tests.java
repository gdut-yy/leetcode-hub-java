import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6393Tests {
    private final Solution6393 solution6393 = new Solution6393();

    @Test
    public void example1() {
        int[] nums = {3, -1, -5, 2, 5, -9};
        long expected = 1350;
        Assertions.assertEquals(expected, solution6393.maxStrength(nums));
        Assertions.assertEquals(expected, solution6393.maxStrength2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-4, -5, -4};
        long expected = 20;
        Assertions.assertEquals(expected, solution6393.maxStrength(nums));
        Assertions.assertEquals(expected, solution6393.maxStrength2(nums));
    }
}