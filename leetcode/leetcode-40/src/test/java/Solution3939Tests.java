import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3939Tests {
    private final Solution3939 solution3939 = new Solution3939();

    @Test
    public void example1() {
        int[] parent = {-1, 0, 1};
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3939.countValidSubsets(parent, nums, k));
    }

    @Test
    public void example2() {
        int[] parent = {-1, 0, 0, 0};
        int[] nums = {2, 1, 2, 1};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3939.countValidSubsets(parent, nums, k));
    }
}