import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6224Tests {
    private final Solution6224 solution6224 = new Solution6224();

    @Test
    public void example1() {
        int[] nums = {9, 3, 1, 2, 6, 3};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution6224.subarrayGCD(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4};
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution6224.subarrayGCD(nums, k));
    }
}
