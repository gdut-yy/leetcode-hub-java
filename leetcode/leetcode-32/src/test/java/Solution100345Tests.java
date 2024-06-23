import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100345Tests {
    private final Solution100345 solution100345 = new Solution100345();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution100345.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 6, 9};
        int expected = 0;
        Assertions.assertEquals(expected, solution100345.minimumOperations(nums));
    }
}