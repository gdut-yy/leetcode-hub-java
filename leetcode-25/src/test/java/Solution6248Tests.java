import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6248Tests {
    private final Solution6248 solution6248 = new Solution6248();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 4, 5};
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution6248.countSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution6248.countSubarrays(nums, k));
    }
}
