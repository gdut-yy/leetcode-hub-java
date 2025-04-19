import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3505Tests {
    private final Solution3505 solution3505 = new Solution3505();

    @Test
    public void example1() {
        int[] nums = {5, -2, 1, 3, 7, 3, 6, 4, -1};
        int x = 3;
        int k = 2;
        long expected = 8;
        Assertions.assertEquals(expected, solution3505.minOperations(nums, x, k));
    }

    @Test
    public void example2() {
        int[] nums = {9, -2, -2, -2, 1, 5};
        int x = 2;
        int k = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3505.minOperations(nums, x, k));
    }
}