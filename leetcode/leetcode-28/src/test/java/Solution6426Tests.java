import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6426Tests {
    private final Solution6426 solution6426 = new Solution6426();

    @Test
    public void example1() {
        int[] nums = {-2, 0, 2};
        String s = "RLL";
        int d = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution6426.sumDistance(nums, s, d));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0};
        String s = "RL";
        int d = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution6426.sumDistance(nums, s, d));
    }
}