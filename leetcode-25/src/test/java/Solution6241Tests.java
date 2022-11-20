import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6241Tests {
    private final Solution6241 solution6241 = new Solution6241();

    @Test
    public void example1() {
        int[] nums = {4, 4, 2, 4, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution6241.unequalTriplets(nums));
        Assertions.assertEquals(expected, solution6241.unequalTriplets2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution6241.unequalTriplets(nums));
        Assertions.assertEquals(expected, solution6241.unequalTriplets2(nums));
    }
}
