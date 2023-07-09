import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6919Tests {
    private final Solution6919 solution6919 = new Solution6919();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 1, 1, 0};
        int k = 3;
        Assertions.assertTrue(solution6919.checkArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 1, 1};
        int k = 2;
        Assertions.assertFalse(solution6919.checkArray(nums, k));
    }
}