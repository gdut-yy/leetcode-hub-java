import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3987Tests {
    private final Solution3987 solution3987 = new Solution3987();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3987.minimumCost(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 7, 14};
        int k = 4;
        int expected = 15;
        Assertions.assertEquals(expected, solution3987.minimumCost(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int k = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution3987.minimumCost(nums, k));
    }
}