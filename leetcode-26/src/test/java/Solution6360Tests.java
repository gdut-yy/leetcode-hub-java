import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6360Tests {
    private final Solution6360 solution6360 = new Solution6360();

    @Test
    public void example1() {
        int[] nums = {2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution6360.minImpossibleOR(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 3, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution6360.minImpossibleOR(nums));
    }
}