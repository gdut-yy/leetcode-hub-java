import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1719Tests {
    private final Solution1719 solution1719 = new Solution1719();

    @Test
    public void example1() {
        int[][] pairs = UtUtils.stringToInts2("[[1,2],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1719.checkWays(pairs));
    }

    @Test
    public void example2() {
        int[][] pairs = UtUtils.stringToInts2("[[1,2],[2,3],[1,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1719.checkWays(pairs));
    }

    @Test
    public void example3() {
        int[][] pairs = UtUtils.stringToInts2("[[1,2],[2,3],[2,4],[1,5]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1719.checkWays(pairs));
    }
}