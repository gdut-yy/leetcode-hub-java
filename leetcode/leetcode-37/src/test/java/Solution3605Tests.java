import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3605Tests {
    private final Solution3605.V1 solution3605_v1 = new Solution3605.V1();
    private final Solution3605.V2 solution3605_v2 = new Solution3605.V2();

    @Test
    public void example1() {
        int[] nums = {3, 5, 10};
        int maxC = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3605_v1.minStable(nums, maxC));
        Assertions.assertEquals(expected, solution3605_v2.minStable(nums, maxC));
    }

    @Test
    public void example2() {
        int[] nums = {2, 6, 8};
        int maxC = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3605_v1.minStable(nums, maxC));
        Assertions.assertEquals(expected, solution3605_v2.minStable(nums, maxC));
    }

    @Test
    public void example3() {
        int[] nums = {2, 4, 9, 6};
        int maxC = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3605_v1.minStable(nums, maxC));
        Assertions.assertEquals(expected, solution3605_v2.minStable(nums, maxC));
    }
}