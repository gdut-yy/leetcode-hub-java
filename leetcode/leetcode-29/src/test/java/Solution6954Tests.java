import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution6954Tests {
    private final Solution6954 solution6954 = new Solution6954();

    @Test
    public void example1() {
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int target = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution6954.countPairs(nums, target));
        Assertions.assertEquals(expected, solution6954.countPairs2(nums, target));
    }

    @Test
    public void example2() {
        List<Integer> nums = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);
        int target = -2;
        int expected = 10;
        Assertions.assertEquals(expected, solution6954.countPairs(nums, target));
        Assertions.assertEquals(expected, solution6954.countPairs2(nums, target));
    }
}