import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100136Tests {
    private final Solution100136 solution100136 = new Solution100136();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 8;
        Assertions.assertEquals(expected, solution100136.numberOfGoodPartitions(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution100136.numberOfGoodPartitions(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution100136.numberOfGoodPartitions(nums));
    }
}