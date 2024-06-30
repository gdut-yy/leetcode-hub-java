import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100357Tests {
    private final Solution100357 solution100357 = new Solution100357();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution100357.maximumLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 1, 2, 1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution100357.maximumLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution100357.maximumLength(nums));
    }
}