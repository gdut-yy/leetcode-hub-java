import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution3488Tests {
    private final Solution3488 solution3488 = new Solution3488();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 4, 1, 3, 2};
        int[] queries = {0, 3, 5};
        List<Integer> expected = Arrays.asList(2, -1, 3);
        Assertions.assertEquals(expected, solution3488.solveQueries(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int[] queries = {0, 1, 2, 3};
        List<Integer> expected = Arrays.asList(-1, -1, -1, -1);
        Assertions.assertEquals(expected, solution3488.solveQueries(nums, queries));
    }
}