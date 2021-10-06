import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution414Tests {
    private final Solution414 solution414 = new Solution414();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution414.thirdMax(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution414.thirdMax(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 3, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution414.thirdMax(nums));
    }
}
