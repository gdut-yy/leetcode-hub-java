import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6136Tests {
    private final Solution6136 solution6136 = new Solution6136();

    @Test
    public void example1() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution6136.arithmeticTriplets(nums, diff));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution6136.arithmeticTriplets(nums, diff));
    }
}
