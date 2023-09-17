import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution8039Tests {
    private final Solution8039 solution8039 = new Solution8039();

    @Test
    public void example1() {
        List<Integer> nums = List.of(3, 4, 5, 1, 2);
        int expected = 2;
        Assertions.assertEquals(expected, solution8039.minimumRightShifts(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 3, 5);
        int expected = 0;
        Assertions.assertEquals(expected, solution8039.minimumRightShifts(nums));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(2, 1, 4);
        int expected = -1;
        Assertions.assertEquals(expected, solution8039.minimumRightShifts(nums));
    }
}