import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6467Tests {
    private final Solution6467 solution6467 = new Solution6467();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 3, 2, 3, 1, 3);
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray(nums, k));
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray2(nums, k));
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray3(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 1, 2, 2, 1, 1);
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray(nums, k));
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray2(nums, k));
        Assertions.assertEquals(expected, solution6467.longestEqualSubarray3(nums, k));
    }
}