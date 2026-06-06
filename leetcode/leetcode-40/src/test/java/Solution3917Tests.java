import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3917Tests {
    private final Solution3917.V1 solution3917_v1 = new Solution3917.V1();
    private final Solution3917.V2 solution3917_v2 = new Solution3917.V2();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {2, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution3917_v1.countOppositeParity(nums));
        Assertions.assertArrayEquals(expected, solution3917_v2.countOppositeParity(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution3917_v1.countOppositeParity(nums));
        Assertions.assertArrayEquals(expected, solution3917_v2.countOppositeParity(nums));
    }
}