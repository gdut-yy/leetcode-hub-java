import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6472Tests {
    private final Solution6472 solution6472 = new Solution6472();

    @Test
    public void example1() {
        int n = 3;
        int[][] queries = UtUtils.stringToInts2("[[0,0,1],[1,2,2],[0,2,3],[1,0,4]]");
        long expected = 23;
        Assertions.assertEquals(expected, solution6472.matrixSumQueries(n, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] queries = UtUtils.stringToInts2("[[0,0,4],[0,1,2],[1,0,1],[0,2,3],[1,2,1]]");
        long expected = 17;
        Assertions.assertEquals(expected, solution6472.matrixSumQueries(n, queries));
    }
}