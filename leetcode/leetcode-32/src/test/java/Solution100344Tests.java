import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100344Tests {
    private final Solution100344 solution100344 = new Solution100344();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 1, 0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution100344.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 1, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solution100344.minOperations(nums));
    }
}