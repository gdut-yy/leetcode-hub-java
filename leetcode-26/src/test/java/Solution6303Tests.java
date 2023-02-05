import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6303Tests {
    private final Solution6303 solution6303 = new Solution6303();

    @Test
    public void example1() {
        int[] nums = {13, 25, 83, 77};
        int[] expected = {1, 3, 2, 5, 8, 3, 7, 7};
        Assertions.assertArrayEquals(expected, solution6303.separateDigits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 1, 3, 9};
        int[] expected = {7, 1, 3, 9};
        Assertions.assertArrayEquals(expected, solution6303.separateDigits(nums));
    }
}