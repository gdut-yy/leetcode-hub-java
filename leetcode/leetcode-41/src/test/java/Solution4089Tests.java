import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4089Tests {
    private final Solution4089 solution4089 = new Solution4089();

    @Test
    public void example1() {
        int[] nums = {1, 4, 7, 3};
        int minK = 1;
        int maxK = 5;
        long expected = 4;
        Assertions.assertEquals(expected, solution4089.countSubarrays(nums, minK, maxK));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1};
        int minK = 1;
        int maxK = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution4089.countSubarrays(nums, minK, maxK));
    }
}
