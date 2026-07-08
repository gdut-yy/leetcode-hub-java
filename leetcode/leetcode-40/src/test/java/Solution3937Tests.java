import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3937Tests {
    private final Solution3937 solution3936 = new Solution3937();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 8};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3936.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3936.minOperations(nums, k));
    }
}