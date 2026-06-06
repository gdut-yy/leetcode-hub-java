import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3911Tests {
    private final Solution3911 solution3911 = new Solution3911();

    @Test
    public void example1() {
        int[] nums = {1, 4, 7};
        int[][] queries = UtUtils.stringToInts2("[[0,2,1],[1,1,2],[0,0,3]]");
        int[] expected = {2, 6, 6};
        Assertions.assertArrayEquals(expected, solution3911.kthRemainingInteger(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 5, 8};
        int[][] queries = UtUtils.stringToInts2("[[0,1,2],[1,2,1],[0,2,4]]");
        int[] expected = {6, 2, 12};
        Assertions.assertArrayEquals(expected, solution3911.kthRemainingInteger(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {3, 6};
        int[][] queries = UtUtils.stringToInts2("[[0,1,1],[1,1,3]]");
        int[] expected = {2, 8};
        Assertions.assertArrayEquals(expected, solution3911.kthRemainingInteger(nums, queries));
    }
}