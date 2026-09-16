import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4013Tests {
    private final Solution4013 solution4013 = new Solution4013();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2};
        int a = 3;
        int b = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution4013.countRatioSubarrays(nums, a, b));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 1};
        int a = 2;
        int b = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution4013.countRatioSubarrays(nums, a, b));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 2};
        int a = 1;
        int b = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution4013.countRatioSubarrays(nums, a, b));
    }
}