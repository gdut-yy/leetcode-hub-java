import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3434Tests {
    private final Solution3434 solution3434 = new Solution3434();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3434.maxFrequency(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 2, 3, 4, 5, 5, 4, 3, 2, 2};
        int k = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution3434.maxFrequency(nums, k));
    }
}