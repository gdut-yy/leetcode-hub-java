import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3785Tests {
    private final Solution3785 solution3785 = new Solution3785();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] forbidden = {3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3785.minSwaps(nums, forbidden));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6, 6, 5};
        int[] forbidden = {4, 6, 5, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3785.minSwaps(nums, forbidden));
    }

    @Test
    public void example3() {
        int[] nums = {7, 7};
        int[] forbidden = {8, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution3785.minSwaps(nums, forbidden));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2};
        int[] forbidden = {2, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3785.minSwaps(nums, forbidden));
    }
}