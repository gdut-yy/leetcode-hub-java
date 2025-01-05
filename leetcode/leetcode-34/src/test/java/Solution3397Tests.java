import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3397Tests {
    private final Solution3397 solution3397 = new Solution3397();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution3397.maxDistinctElements(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 4, 4};
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3397.maxDistinctElements(nums, k));
    }
}