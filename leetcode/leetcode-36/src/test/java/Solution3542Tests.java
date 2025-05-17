import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3542Tests {
    private final Solution3542.V1 solution3542_v1 = new Solution3542.V1();
    private final Solution3542.V2 solution3542_v2 = new Solution3542.V2();

    @Test
    public void example1() {
        int[] nums = {0, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3542_v1.minOperations(nums));
        Assertions.assertEquals(expected, solution3542_v2.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3542_v1.minOperations(nums));
        Assertions.assertEquals(expected, solution3542_v2.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 2, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution3542_v1.minOperations(nums));
        Assertions.assertEquals(expected, solution3542_v2.minOperations(nums));
    }
}