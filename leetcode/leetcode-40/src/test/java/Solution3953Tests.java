import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3953Tests {
    private final Solution3953 solution3953 = new Solution3953();

    @Test
    public void example1() {
        int[] nums = {3, 4, 6};
        int maxVal = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution3953.maxScore(nums, maxVal));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int maxVal = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3953.maxScore(nums, maxVal));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2};
        int maxVal = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3953.maxScore(nums, maxVal));
    }
}