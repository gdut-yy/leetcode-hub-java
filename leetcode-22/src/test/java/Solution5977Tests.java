import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5977Tests {
    private final Solution5977 solution5977 = new Solution5977();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution5977.minSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution5977.minSwaps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 0, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution5977.minSwaps(nums));
    }
}
