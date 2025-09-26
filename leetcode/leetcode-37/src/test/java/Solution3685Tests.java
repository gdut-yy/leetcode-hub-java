import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3685Tests {
    private final Solution3685 solution3685 = new Solution3685();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 4};
        int k = 5;
        boolean[] expected = {false, false, true, true};
        Assertions.assertArrayEquals(expected, solution3685.subsequenceSumAfterCapping(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        boolean[] expected = {true,true,true,true,true};
        Assertions.assertArrayEquals(expected, solution3685.subsequenceSumAfterCapping(nums, k));
    }
}