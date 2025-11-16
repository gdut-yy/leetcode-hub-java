import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3745Tests {
    private final Solution3745 solution3745 = new Solution3745();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution3745.maximizeExpressionOfThree(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-2, 0, 5, -2, 4};
        int expected = 11;
        Assertions.assertEquals(expected, solution3745.maximizeExpressionOfThree(nums));
    }
}