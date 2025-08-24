import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3654Tests {
    private final Solution3654 solution3654 = new Solution3654();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        long expected = 1;
        Assertions.assertEquals(expected, solution3654.minArraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solution3654.minArraySum(nums, k));
    }
}