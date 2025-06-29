import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3589Tests {
    private final Solution3589 solution3589 = new Solution3589();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3589.primeSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 7};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3589.primeSubarray(nums, k));
    }
}