import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3523Tests {
    private final Solution3523 solution3523 = new Solution3523();

    @Test
    public void example1() {
        int[] nums = {4, 2, 5, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution3523.maximumPossibleSize(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3523.maximumPossibleSize(nums));
    }
}