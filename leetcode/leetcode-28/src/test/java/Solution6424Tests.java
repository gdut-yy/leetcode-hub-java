import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6424Tests {
    private final Solution6424 solution6424 = new Solution6424();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution6424.semiOrderedPermutation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution6424.semiOrderedPermutation(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 4, 2, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution6424.semiOrderedPermutation(nums));
    }
}