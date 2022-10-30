import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6226Tests {
    private final Solution6226 solution6226 = new Solution6226();

    @Test
    public void example1() {
        int[] nums = {3, 7, 8, 1, 1, 5};
        int space = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution6226.destroyTargets(nums, space));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 2, 4, 6};
        int space = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution6226.destroyTargets(nums, space));
    }

    @Test
    public void example3() {
        int[] nums = {6, 2, 5};
        int space = 100;
        int expected = 2;
        Assertions.assertEquals(expected, solution6226.destroyTargets(nums, space));
    }
}
