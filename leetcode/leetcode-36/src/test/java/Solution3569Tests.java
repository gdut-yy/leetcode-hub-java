import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3569Tests {
    private final Solution3569 solution3569 = new Solution3569();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 1, 2};
        int[][] queries = UtUtils.stringToInts2("[[1,2],[3,3]]");
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution3569.maximumCount(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 4};
        int[][] queries = UtUtils.stringToInts2("[[0,1]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution3569.maximumCount(nums, queries));
    }
}