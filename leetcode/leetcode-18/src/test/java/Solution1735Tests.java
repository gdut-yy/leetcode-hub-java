import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1735Tests {
    private final Solution1735 solution1735 = new Solution1735();

    @Test
    public void example1() {
        int[][] queries = UtUtils.stringToInts2("[[2,6],[5,1],[73,660]]");
        int[] expected = {4, 1, 50734910};
        Assertions.assertArrayEquals(expected, solution1735.waysToFillArray(queries));
    }

    @Test
    public void example2() {
        int[][] queries = UtUtils.stringToInts2("[[1,1],[2,2],[3,3],[4,4],[5,5]]");
        int[] expected = {1, 2, 3, 10, 5};
        Assertions.assertArrayEquals(expected, solution1735.waysToFillArray(queries));
    }
}