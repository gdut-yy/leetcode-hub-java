import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3574Tests {
    private final Solution3574 solution3574 = new Solution3574();

    @Test
    public void example1() {
        int[] nums = {2, 4};
        int k = 1;
        long expected = 8;
        Assertions.assertEquals(expected, solution3574.maxGCDScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 5, 7};
        int k = 2;
        long expected = 14;
        Assertions.assertEquals(expected, solution3574.maxGCDScore(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 5, 5};
        int k = 1;
        long expected = 15;
        Assertions.assertEquals(expected, solution3574.maxGCDScore(nums, k));
    }
}