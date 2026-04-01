import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3880Tests {
    private final Solution3880.V1 solution3880_v1 = new Solution3880.V1();
    private final Solution3880.V2 solution3880_v2 = new Solution3880.V2();

    @Test
    public void example1() {
        int[] nums = {1, 0, 0, 2, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3880_v1.minAbsoluteDifference(nums));
        Assertions.assertEquals(expected, solution3880_v2.minAbsoluteDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 1, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution3880_v1.minAbsoluteDifference(nums));
        Assertions.assertEquals(expected, solution3880_v2.minAbsoluteDifference(nums));
    }
}