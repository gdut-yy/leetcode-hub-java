import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3912Tests {
    private final Solution3912 solution3912 = new Solution3912();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4, 2, 3, 2};
        List<Integer> expected = List.of(1, 2, 4, 3, 2);
        Assertions.assertEquals(expected, solution3912.findValidElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        List<Integer> expected = List.of(5, 5);
        Assertions.assertEquals(expected, solution3912.findValidElements(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution3912.findValidElements(nums));
    }
}