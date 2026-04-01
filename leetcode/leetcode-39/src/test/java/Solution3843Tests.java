import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3843Tests {
    private final Solution3843 solution3843 = new Solution3843();

    @Test
    public void example1() {
        int[] nums = {20, 10, 30, 30};
        int expected = 30;
        Assertions.assertEquals(expected, solution3843.firstUniqueFreq(nums));
    }

    @Test
    public void example2() {
        int[] nums = {20, 20, 10, 30, 30, 30};
        int expected = 20;
        Assertions.assertEquals(expected, solution3843.firstUniqueFreq(nums));
    }

    @Test
    public void example3() {
        int[] nums = {10, 10, 20, 20};
        int expected = -1;
        Assertions.assertEquals(expected, solution3843.firstUniqueFreq(nums));
    }
}