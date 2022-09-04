import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6173Tests {
    private final Solution6173 solution6173 = new Solution6173();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[1,0,1],[0,1,1],[0,0,1]]");
        int cols = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution6173.maximumRows(mat, cols));
        Assertions.assertEquals(expected, solution6173.maximumRows2(mat, cols));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1],[0]]");
        int cols = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution6173.maximumRows(mat, cols));
        Assertions.assertEquals(expected, solution6173.maximumRows2(mat, cols));
    }
}
