import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3701Tests {
    private final Solution3701 solution3701 = new Solution3701();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 7};
        int expected = -4;
        Assertions.assertEquals(expected, solution3701.alternatingSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {100};
        int expected = 100;
        Assertions.assertEquals(expected, solution3701.alternatingSum(nums));
    }
}