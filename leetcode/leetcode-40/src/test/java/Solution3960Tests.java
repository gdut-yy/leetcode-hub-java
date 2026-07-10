import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3960Tests {
    private final Solution3960 solution3960 = new Solution3960();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1, 2, 3, 3, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution3960.getLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution3960.getLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3960.getLength(nums));
    }
}