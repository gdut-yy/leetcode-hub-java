import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6418Tests {
    private final Solution6418 solution6418 = new Solution6418();

    @Test
    public void example1() {
        int n = 4;
        int[][] queries = UtUtils.stringToInts2("[[0,2],[1,2],[3,1],[1,1],[2,1]]");
        int[] expected = {0, 1, 1, 0, 2};
        Assertions.assertArrayEquals(expected, solution6418.colorTheArray(n, queries));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] queries = UtUtils.stringToInts2("[[0,100000]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution6418.colorTheArray(n, queries));
    }
}