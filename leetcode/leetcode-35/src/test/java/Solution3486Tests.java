import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3486Tests {
    private final Solution3486 solution3486 = new Solution3486();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,3],[1,3,1],[2,4,6],[4,7,2],[3,5,2],[3,6,5],[6,8,3]]");
        int[] nums = {1, 1, 0, 3, 1, 2, 1, 1, 0};
        int[] expected = {9, 3};
        Assertions.assertArrayEquals(expected, solution3486.longestSpecialPath(edges, nums));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,0,3],[0,2,4],[0,3,5]]");
        int[] nums = {1, 1, 0, 2};
        int[] expected = {5, 2};
        Assertions.assertArrayEquals(expected, solution3486.longestSpecialPath(edges, nums));
    }
}