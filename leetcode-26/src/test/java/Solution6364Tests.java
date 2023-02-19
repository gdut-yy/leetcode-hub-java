import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6364Tests {
    private final Solution6364 solution6364 = new Solution6364();

    @Test
    public void example1() {
        int[] nums = {3, 4, 4, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution6364.squareFreeSubsets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution6364.squareFreeSubsets(nums));
    }
}