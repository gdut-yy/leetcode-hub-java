import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6360Tests {
    private final Solution6360 solution6360 = new Solution6360();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 1, 2};
        long[] expected = {5, 0, 3, 4, 0};
        Assertions.assertArrayEquals(expected, solution6360.distance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 5, 3};
        long[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, solution6360.distance(nums));
    }
}