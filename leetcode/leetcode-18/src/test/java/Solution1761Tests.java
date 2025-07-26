import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1761Tests {
    private final Solution1761 solution1761 = new Solution1761();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1761.minTrioDegree(n, edges));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1761.minTrioDegree(n, edges));
    }
}