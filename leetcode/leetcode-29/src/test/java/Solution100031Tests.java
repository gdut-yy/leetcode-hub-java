import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution100031Tests {
    private final Solution100031 solution100031 = new Solution100031();

    @Test
    public void example1() {
        List<Integer> nums = List.of(5, 10, 1, 5, 2);
        int k = 1;
        int expected = 13;
        Assertions.assertEquals(expected, solution100031.sumIndicesWithKSetBits(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(4, 3, 2, 1);
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution100031.sumIndicesWithKSetBits(nums, k));
    }
}