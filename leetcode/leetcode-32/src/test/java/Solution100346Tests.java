import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100346Tests {
    private final Solution100346 solution100346 = new Solution100346();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 0, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution100346.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution100346.minOperations(nums));
    }
}