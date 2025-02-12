import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3427Tests {
    private final Solution3427 solution3427 = new Solution3427();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1};
        int expected = 11;
        Assertions.assertEquals(expected, solution3427.subarraySum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 1, 2};
        int expected = 13;
        Assertions.assertEquals(expected, solution3427.subarraySum(nums));
    }
}