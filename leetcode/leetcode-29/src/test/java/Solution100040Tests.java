import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution100040Tests {
    private final Solution100040 solution100040 = new Solution100040();

    @Test
    public void example1() {
        List<Integer> nums = Arrays.asList(1, 1);
        int expected = 2;
        Assertions.assertEquals(expected, solution100040.countWays(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7);
        int expected = 3;
        Assertions.assertEquals(expected, solution100040.countWays(nums));
    }
}