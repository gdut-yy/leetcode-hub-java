import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4076Tests {
    private final Solution4076 solution4076 = new Solution4076();

    @Test
    public void example1() {
        int[] nums = {2, 4, 6, 3};
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution4076.resilientSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 7, 1};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution4076.resilientSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 5, 4, 8};
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution4076.resilientSubarray(nums, k));
    }
}
