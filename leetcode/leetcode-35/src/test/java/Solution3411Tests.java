import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3411Tests {
    private final Solution3411 solution3411 = new Solution3411();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 1, 1, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solution3411.maxLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 5, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution3411.maxLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 1, 4, 5, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solution3411.maxLength(nums));
    }
}