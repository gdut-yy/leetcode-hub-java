import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5991Tests {
    private final Solution5991 solution5991 = new Solution5991();

    @Test
    public void example1() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] expected = {3, -2, 1, -5, 2, -4};
        Assertions.assertArrayEquals(expected, solution5991.rearrangeArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 1};
        int[] expected = {1, -1};
        Assertions.assertArrayEquals(expected, solution5991.rearrangeArray(nums));
    }
}
