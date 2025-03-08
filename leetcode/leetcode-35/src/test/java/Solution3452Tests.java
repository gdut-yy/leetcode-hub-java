import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3452Tests {
    private final Solution3452 solution3452 = new Solution3452();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 1, 5, 4};
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solution3452.sumOfGoodNumbers(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3452.sumOfGoodNumbers(nums, k));
    }
}