import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3718Tests {
    private final Solution3718 solution3718 = new Solution3718();

    @Test
    public void example1() {
        int[] nums = {8, 2, 3, 4, 6};
        int k = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution3718.missingMultiple(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 7, 10, 15};
        int k = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution3718.missingMultiple(nums, k));
    }
}