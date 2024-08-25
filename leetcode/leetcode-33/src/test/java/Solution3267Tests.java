import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3267Tests {
    private final Solution3267 solution3267 = new Solution3267();

    @Test
    public void example1() {
        int[] nums = {1023, 2310, 2130, 213};
        int expected = 4;
        Assertions.assertEquals(expected, solution3267.countPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 100};
        int expected = 3;
        Assertions.assertEquals(expected, solution3267.countPairs(nums));
    }
}