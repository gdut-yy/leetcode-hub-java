import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6900Tests {
    private final Solution6900 solution6900 = new Solution6900();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 2, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution6900.countCompleteSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        int expected = 10;
        Assertions.assertEquals(expected, solution6900.countCompleteSubarrays(nums));
    }
}