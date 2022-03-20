import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6020Tests {
    private final Solution6020 solution6020 = new Solution6020();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3, 2, 2, 2};
        Assertions.assertTrue(solution6020.divideArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution6020.divideArray(nums));
    }
}
