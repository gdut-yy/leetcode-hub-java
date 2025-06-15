import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3583Tests {
    private final Solution3583 solution3583 = new Solution3583();

    @Test
    public void example1() {
        int[] nums = {6, 3, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution3583.specialTriplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution3583.specialTriplets(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8, 4, 2, 8, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution3583.specialTriplets(nums));
    }
}