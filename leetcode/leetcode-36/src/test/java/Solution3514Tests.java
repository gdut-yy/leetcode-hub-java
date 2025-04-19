import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3514Tests {
    private final Solution3514.V1 solution3514_v1 = new Solution3514.V1();
    private final Solution3514.V2 solution3514_v2 = new Solution3514.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3514_v1.uniqueXorTriplets(nums));
        Assertions.assertEquals(expected, solution3514_v2.uniqueXorTriplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 7, 8, 9};
        int expected = 4;
        Assertions.assertEquals(expected, solution3514_v1.uniqueXorTriplets(nums));
        Assertions.assertEquals(expected, solution3514_v2.uniqueXorTriplets(nums));
    }
}