import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3743Tests {
    private final Solution3743 solution3743 = new Solution3743();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 3};
        int k = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3743.maximumScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 3};
        int k = 1;
        long expected = 2;
        Assertions.assertEquals(expected, solution3743.maximumScore(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 3};
        int k = 4;
        long expected = 3;
        Assertions.assertEquals(expected, solution3743.maximumScore(nums, k));
    }
}