import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6292Tests {
    private final Solution6292 solution6292 = new Solution6292();

    @Test
    public void example1() {
        int n = 3;
        int[][] queries = UtUtils.stringToInts2("[[1,1,2,2],[0,0,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,0],[1,2,1],[0,1,1]]");
        Assertions.assertArrayEquals(expected, solution6292.rangeAddQueries(n, queries));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,0,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1],[1,1]]");
        Assertions.assertArrayEquals(expected, solution6292.rangeAddQueries(n, queries));
    }
}
