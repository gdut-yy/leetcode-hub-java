import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution325Tests {
    private final Solution325 solution325 = new Solution325();

    @Test
    public void example1() {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution325.maxSubArrayLen(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-2, -1, 2, 1};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution325.maxSubArrayLen(nums, k));
    }
}
