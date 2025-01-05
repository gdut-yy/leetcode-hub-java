import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3396Tests {
    private final Solution3396 solution3396 = new Solution3396();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution3396.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 6, 4, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution3396.minimumOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {6, 7, 8, 9};
        int expected = 0;
        Assertions.assertEquals(expected, solution3396.minimumOperations(nums));
    }
}