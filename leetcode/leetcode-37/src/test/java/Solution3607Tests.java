import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3607Tests {
    private final Solution3607 solution3607 = new Solution3607();

    @Test
    public void example1() {
        int c = 5;
        int[][] connections = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,5]]");
        int[][] queries = UtUtils.stringToInts2("[[1,3],[2,1],[1,1],[2,2],[1,2]]");
        int[] expected = {3, 2, 3};
        Assertions.assertArrayEquals(expected, solution3607.processQueries(c, connections, queries));
    }

    @Test
    public void example2() {
        int c = 3;
        int[][] connections = UtUtils.stringToInts2("[]");
        int[][] queries = UtUtils.stringToInts2("[[1,1],[2,1],[1,1]]");
        int[] expected = {1, -1};
        Assertions.assertArrayEquals(expected, solution3607.processQueries(c, connections, queries));
    }
}