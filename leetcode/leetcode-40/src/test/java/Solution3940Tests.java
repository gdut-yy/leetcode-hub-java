import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3940Tests {
    private final Solution3940 solution3940 = new Solution3940();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 1, 2, 2, 3};
        Assertions.assertArrayEquals(expected, solution3940.limitOccurrences(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1,2,3};
        int k = 1;
        int[] expected = {1,2,3};
        Assertions.assertArrayEquals(expected, solution3940.limitOccurrences(nums, k));
    }
}