import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6346Tests {
    private final Solution6346 solution6346 = new Solution6346();

    @Test
    public void example1() {
        int[] nums = {2, 3, 5, 9};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution6346.minCapability(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 7, 9, 3, 1};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6346.minCapability(nums, k));
    }
}