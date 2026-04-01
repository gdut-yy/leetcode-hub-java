import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3886Tests {
    private final Solution3886 solution3886 = new Solution3886();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3886.sortableIntegers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 6, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution3886.sortableIntegers(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 8};
        int expected = 3;
        Assertions.assertEquals(expected, solution3886.sortableIntegers(nums));
    }
}