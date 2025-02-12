import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3428Tests {
    private final Solution3428 solution3428 = new Solution3428();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 2;
        int expected = 24;
        Assertions.assertEquals(expected, solution3428.minMaxSums(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 0, 6};
        int k = 1;
        int expected = 22;
        Assertions.assertEquals(expected, solution3428.minMaxSums(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solution3428.minMaxSums(nums, k));
    }
}