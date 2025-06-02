import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3553Tests {
    private final Solution3553 solution3553 = new Solution3553();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,3],[1,3,5],[1,4,4],[2,5,6]]");
        int[][] queries = UtUtils.stringToInts2("[[2,3,4],[0,2,5]]");
        int[] expected = {12, 11};
        Assertions.assertArrayEquals(expected, solution3553.minimumWeight(edges, queries));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,0,8],[0,2,7]]");
        int[][] queries = UtUtils.stringToInts2("[[0,1,2]]");
        int[] expected = {15};
        Assertions.assertArrayEquals(expected, solution3553.minimumWeight(edges, queries));
    }
}