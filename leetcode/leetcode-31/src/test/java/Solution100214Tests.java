import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100214Tests {
    private final Solution100214 solution100214 = new Solution100214();

    @Test
    public void example1() {
        int[] nums = {2, 3, -5};
        int expected = 1;
        Assertions.assertEquals(expected, solution100214.returnToBoundaryCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, -3, -4};
        int expected = 0;
        Assertions.assertEquals(expected, solution100214.returnToBoundaryCount(nums));
    }
}