import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3936Tests {
    private final Solution3936 solution3936 = new Solution3936();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 3, 12};
        int expected = 2;
        Assertions.assertEquals(expected, solution3936.minimumSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3936.minimumSwaps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution3936.minimumSwaps(nums));
    }
}