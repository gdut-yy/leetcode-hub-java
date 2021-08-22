import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution15Tests {
    private final Solution15 solution15 = new Solution15();

    @Test
    public void example1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {};
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }
}
