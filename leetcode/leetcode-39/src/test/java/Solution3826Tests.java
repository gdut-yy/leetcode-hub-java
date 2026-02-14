import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3826Tests {
    private final Solution3826 solution3826 = new Solution3826();

    @Test
    public void example1() {
        int[] nums = {5, 1, 2, 1};
        int k = 2;
        long expected = 25;
        Assertions.assertEquals(expected, solution3826.minPartitionScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int k = 1;
        long expected = 55;
        Assertions.assertEquals(expected, solution3826.minPartitionScore(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        int k = 3;
        long expected = 3;
        Assertions.assertEquals(expected, solution3826.minPartitionScore(nums, k));
    }
}