import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4051Tests {
    private final Solution4051 solution4051 = new Solution4051();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int goal = 4;
        int k = 1;
        long expected = 5;
        Assertions.assertEquals(expected, solution4051.distantSubarrays(nums, goal, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, -1, 3};
        int goal = 2;
        int k = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution4051.distantSubarrays(nums, goal, k));
    }

    @Test
    public void example3() {
        int[] nums = {-3, 1, 2};
        int goal = 0;
        int k = 3;
        long expected = 2;
        Assertions.assertEquals(expected, solution4051.distantSubarrays(nums, goal, k));
    }
}