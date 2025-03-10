import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3347Tests {
    private final Solution3347.V1 solution3347_v1 = new Solution3347.V1();
    private final Solution3347.V2 solution3347_v2 = new Solution3347.V2();

    @Test
    public void example1() {
        int[] nums = {1, 4, 5};
        int k = 1;
        int numOperations = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3347_v1.maxFrequency(nums, k, numOperations));
        Assertions.assertEquals(expected, solution3347_v2.maxFrequency(nums, k, numOperations));
    }

    @Test
    public void example2() {
        int[] nums = {5, 11, 20, 20};
        int k = 5;
        int numOperations = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3347_v1.maxFrequency(nums, k, numOperations));
        Assertions.assertEquals(expected, solution3347_v2.maxFrequency(nums, k, numOperations));
    }
}