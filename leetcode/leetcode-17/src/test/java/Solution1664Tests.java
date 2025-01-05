import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1664Tests {
    private final Solution1664 solution1664 = new Solution1664();

    @Test
    public void example1() {
        int[] nums = {2, 1, 6, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution1664.waysToMakeFair(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1664.waysToMakeFair(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1664.waysToMakeFair(nums));
    }
}