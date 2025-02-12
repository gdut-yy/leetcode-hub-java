import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3432Tests {
    private final Solution3432 solution3432 = new Solution3432();

    @Test
    public void example1() {
        int[] nums = {10, 10, 3, 7, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution3432.countPartitions(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution3432.countPartitions(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 4, 6, 8};
        int expected = 3;
        Assertions.assertEquals(expected, solution3432.countPartitions(nums));
    }
}