import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1703Tests {
    private final Solution1703 solution1703 = new Solution1703();

    @Test
    public void example1() {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1703.minMoves(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 0, 0, 0, 0, 1, 1};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution1703.minMoves(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 0, 1};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution1703.minMoves(nums, k));
    }
}