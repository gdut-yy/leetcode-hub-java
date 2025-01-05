import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3388Tests {
    private final Solution3388 solution3388 = new Solution3388();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3388.beautifulSplits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3388.beautifulSplits(nums));
    }
}