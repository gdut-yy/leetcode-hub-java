import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3904Tests {
    private final Solution3904 solution3904 = new Solution3904();

    @Test
    public void example1() {
        int[] nums = {5, 0, 1, 4};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3904.firstStableIndex(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3904.firstStableIndex(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int k = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution3904.firstStableIndex(nums, k));
    }
}