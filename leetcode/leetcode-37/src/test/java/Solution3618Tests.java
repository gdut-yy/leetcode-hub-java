import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3618Tests {
    private final Solution3618 solution3618 = new Solution3618();

    @Test
    public void example1() {
        int[] nums = {2, 3, 4};
        long expected = 1;
        Assertions.assertEquals(expected, solution3618.splitArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 5, 7, 0};
        long expected = 3;
        Assertions.assertEquals(expected, solution3618.splitArray(nums));
    }
}