import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6283Tests {
    private final Solution6283 solution6283 = new Solution6283();

    @Test
    public void example1() {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution6283.maximumCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution6283.maximumCount(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 20, 66, 1314};
        int expected = 4;
        Assertions.assertEquals(expected, solution6283.maximumCount(nums));
    }
}
