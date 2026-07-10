import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3984Tests {
    private final Solution3984 solution3984 = new Solution3984();

    @Test
    public void example1() {
        int[] nums = {1, 4, 6, 8};
        int expected = 36;
        Assertions.assertEquals(expected, solution3984.divisibleGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution3984.divisibleGame(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = 1000000005;
        Assertions.assertEquals(expected, solution3984.divisibleGame(nums));
    }
}