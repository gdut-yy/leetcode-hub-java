import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3824Tests {
    private final Solution3824 solution3824 = new Solution3824();

    @Test
    public void example1() {
        int[] nums = {3, 7, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution3824.minimumK(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3824.minimumK(nums));
    }
}