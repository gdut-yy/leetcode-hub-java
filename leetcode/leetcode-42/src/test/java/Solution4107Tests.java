import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4107Tests {
    private final Solution4107 solution4107 = new Solution4107();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] target = {3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution4107.countSuffix(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 6, 4, 6};
        int[] target = {1, 5, 6, 6, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution4107.countSuffix(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {7, 6, 8};
        int[] target = {8, 6, 7};
        int expected = 0;
        Assertions.assertEquals(expected, solution4107.countSuffix(nums, target));
    }
}
