import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4067Tests {
    private final Solution4067 solution4067 = new Solution4067();

    @Test
    public void example1() {
        int[] nums = {2, 3, 5, 3, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution4067.maxSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution4067.maxSubarray(nums));
    }
}
