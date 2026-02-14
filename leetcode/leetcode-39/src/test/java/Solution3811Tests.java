import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3811Tests {
    private final Solution3811 solution3811 = new Solution3811();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 4};
        int target1 = 1;
        int target2 = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution3811.alternatingXOR(nums, target1, target2));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 0};
        int target1 = 1;
        int target2 = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution3811.alternatingXOR(nums, target1, target2));
    }

    @Test
    public void example3() {
        int[] nums = {7};
        int target1 = 1;
        int target2 = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution3811.alternatingXOR(nums, target1, target2));
    }
}