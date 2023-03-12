import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6316Tests {
    private final Solution6316 solution6316 = new Solution6316();

    @Test
    public void example1() {
        int[] nums = {2, -1, 0, 1, -3, 3, -3};
        int expected = 6;
        Assertions.assertEquals(expected, solution6316.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-2, -3, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution6316.maxScore(nums));
    }
}