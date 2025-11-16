import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3736Tests {
    private final Solution3736 solution3736 = new Solution3736();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3736.minMoves(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3736.minMoves(nums));
    }
}