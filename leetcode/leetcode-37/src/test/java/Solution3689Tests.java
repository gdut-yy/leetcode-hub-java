import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3689Tests {
    private final Solution3689 solution3689 = new Solution3689();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2};
        int k = 2;
        long expected = 4;
        Assertions.assertEquals(expected, solution3689.maxTotalValue(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        long expected = 12;
        Assertions.assertEquals(expected, solution3689.maxTotalValue(nums, k));
    }
}