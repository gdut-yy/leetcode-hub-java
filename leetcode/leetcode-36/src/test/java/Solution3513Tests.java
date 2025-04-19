import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3513Tests {
    private final Solution3513 solution3513 = new Solution3513();

    @Test
    public void example1() {
        int[] nums = {1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3513.uniqueXorTriplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution3513.uniqueXorTriplets(nums));
    }
}