import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6911Tests {
    private final Solution6911 solution6911 = new Solution6911();

    @Test
    public void example1() {
        int[] nums = {5, 4, 2, 4};
        long expected = 8;
        Assertions.assertEquals(expected, solution6911.continuousSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        long expected = 6;
        Assertions.assertEquals(expected, solution6911.continuousSubarrays(nums));
    }
}