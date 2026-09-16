import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4033Tests {
    private final Solution4033 solution4033 = new Solution4033();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1};
        int k = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,3],[1,2]]");
        boolean[] expected = {false, true, false};
        Assertions.assertArrayEquals(expected, solution4033.validSubarrays(nums, k, queries));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3};
        int k = 1;
        int[][] queries = UtUtils.stringToInts2("[[1,2],[0,2]]");
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, solution4033.validSubarrays(nums, k, queries));
    }
}