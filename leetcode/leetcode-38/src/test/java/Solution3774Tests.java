import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3774Tests {
    private final Solution3774 solution3774 = new Solution3774();

    @Test
    public void example1() {
        int[] nums = {5, 2, 2, 4};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution3774.absDifference(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {100};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution3774.absDifference(nums, k));
    }
}