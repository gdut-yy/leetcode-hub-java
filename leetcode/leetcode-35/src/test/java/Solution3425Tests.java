import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3425Tests {
    private final Solution3425 solution3425 = new Solution3425();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,3],[1,3,5],[1,4,4],[2,5,6]]");
        int[] nums = {2, 1, 2, 1, 3, 1};
        int[] expected = {6, 2};
        Assertions.assertArrayEquals(expected, solution3425.longestSpecialPath(edges, nums));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,0,8]]");
        int[] nums = {2, 2};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3425.longestSpecialPath(edges, nums));
    }
}