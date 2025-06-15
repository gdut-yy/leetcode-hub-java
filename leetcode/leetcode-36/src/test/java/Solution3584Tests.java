import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3584Tests {
    private final Solution3584 solution3584 = new Solution3584();

    @Test
    public void example1() {
        int[] nums = {-1, -9, 2, 3, -2, -3, 1};
        int m = 1;
        long expected = 81;
        Assertions.assertEquals(expected, solution3584.maximumProduct(nums, m));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, -5, 5, 6, -4};
        int m = 3;
        long expected = 20;
        Assertions.assertEquals(expected, solution3584.maximumProduct(nums, m));
    }

    @Test
    public void example3() {
        int[] nums = {2, -1, 2, -6, 5, 2, -5, 7};
        int m = 2;
        long expected = 35;
        Assertions.assertEquals(expected, solution3584.maximumProduct(nums, m));
    }
}