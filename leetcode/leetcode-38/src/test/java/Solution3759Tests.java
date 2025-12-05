import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3759Tests {
    private final Solution3759 solution3759 = new Solution3759();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3759.countElements(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3759.countElements(nums, k));
    }
}