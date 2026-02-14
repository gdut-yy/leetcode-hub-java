import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3833Tests {
    private final Solution3833 solution3833 = new Solution3833();

    @Test
    public void example1() {
        int[] nums = {5, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3833.dominantIndices(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution3833.dominantIndices(nums));
    }
}