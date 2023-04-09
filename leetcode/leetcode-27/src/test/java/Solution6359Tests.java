import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6359Tests {
    private final Solution6359 solution6359 = new Solution6359();

    @Test
    public void example1() {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution6359.minimizeMax(nums, p));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 1, 2};
        int p = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution6359.minimizeMax(nums, p));
    }
}