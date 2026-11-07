import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4099Tests {
    private final Solution4099 solution4099 = new Solution4099();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 4};
        int[] locked = {0, 1, 0, 1};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution4099.minOperations(nums, locked, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 2};
        int[] locked = {1, 0, 1};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution4099.minOperations(nums, locked, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 1};
        int[] locked = {1, 0, 0};
        int k = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution4099.minOperations(nums, locked, k));
    }
}
