import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100271Tests {
    private final Solution100271 solution100271 = new Solution100271();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution100271.minimumSubarrayLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 8};
        int k = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution100271.minimumSubarrayLength(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2};
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution100271.minimumSubarrayLength(nums, k));
    }
}