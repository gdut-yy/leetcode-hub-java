import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6000Tests {
    private final Solution6000 solution6000 = new Solution6000();

    @Test
    public void example1() {
        int[] nums = {4, 1, 2, 3};
        int[] expected = {2, 3, 4, 1};
        Assertions.assertArrayEquals(expected, solution6000.sortEvenOdd(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1};
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution6000.sortEvenOdd(nums));
    }
}
