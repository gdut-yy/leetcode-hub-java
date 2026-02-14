import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3834Tests {
    private final Solution3834 solution3834 = new Solution3834();

    @Test
    public void example1() {
        int[] nums = {3, 1, 1, 2};
        List<Long> expected = List.of(3L, 4L);
        Assertions.assertEquals(expected, solution3834.mergeAdjacent(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 4};
        List<Long> expected = List.of(8L);
        Assertions.assertEquals(expected, solution3834.mergeAdjacent(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 7, 5};
        List<Long> expected = List.of(3L, 7L, 5L);
        Assertions.assertEquals(expected, solution3834.mergeAdjacent(nums));
    }
}