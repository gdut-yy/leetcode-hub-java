import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3979Tests {
    private final Solution3979 solution3979 = new Solution3979();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 2, 8};
        int k = 2;
        int expected = 13;
        Assertions.assertEquals(expected, solution3979.maxValidPairSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5,1,9};
        int k = 1;
        int expected = 14;
        Assertions.assertEquals(expected, solution3979.maxValidPairSum(nums, k));
    }
}