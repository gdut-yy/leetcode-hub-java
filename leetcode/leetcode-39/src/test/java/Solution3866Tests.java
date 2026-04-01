import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3866Tests {
    private final Solution3866 solution3866 = new Solution3866();

    @Test
    public void example1() {
        int[] nums = {3, 4, 2, 5, 4, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solution3866.firstUniqueEven(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solution3866.firstUniqueEven(nums));
    }
}