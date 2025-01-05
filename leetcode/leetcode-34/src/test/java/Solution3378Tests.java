import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3378Tests {
    private final Solution3378 solution3378 = new Solution3378();

    @Test
    public void example1() {
        int[] nums = {2, 4, 8, 3, 9};
        int threshold = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution3378.countComponents(nums, threshold));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 8, 3, 9, 12};
        int threshold = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution3378.countComponents(nums, threshold));
    }
}