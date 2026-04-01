import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3847Tests {
    private final Solution3847 solution3847 = new Solution3847();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution3847.scoreDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 2, 1, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3847.scoreDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = -1;
        Assertions.assertEquals(expected, solution3847.scoreDifference(nums));
    }
}