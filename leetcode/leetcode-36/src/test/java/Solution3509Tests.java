import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3509Tests {
    private final Solution3509 solution3509 = new Solution3509();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 2;
        int limit = 10;
        int expected = 6;
        Assertions.assertEquals(expected, solution3509.maxProduct(nums, k, limit));
    }

    @Test
    public void example2() {
        int[] nums = {0, 2, 3};
        int k = -5;
        int limit = 12;
        int expected = -1;
        Assertions.assertEquals(expected, solution3509.maxProduct(nums, k, limit));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 3, 3};
        int k = 0;
        int limit = 9;
        int expected = 9;
        Assertions.assertEquals(expected, solution3509.maxProduct(nums, k, limit));
    }
}