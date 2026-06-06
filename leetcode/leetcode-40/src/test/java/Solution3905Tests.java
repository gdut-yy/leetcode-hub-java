import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3905Tests {
    private final Solution3905 solution3905 = new Solution3905();

    @Test
    public void example1() {
        int n = 3;
        int m = 3;
        int[][] sources = UtUtils.stringToInts2("[[0,0,1],[2,2,2]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,2],[1,2,2],[2,2,2]]");
        Assertions.assertArrayEquals(expected, solution3905.colorGrid(n, m, sources));
    }

    @Test
    public void example2() {
        int n = 3;
        int m = 3;
        int[][] sources = UtUtils.stringToInts2("[[0,1,3],[1,1,5]]");
        int[][] expected = UtUtils.stringToInts2("[[3,3,3],[5,5,5],[5,5,5]]");
        Assertions.assertArrayEquals(expected, solution3905.colorGrid(n, m, sources));
    }

    @Test
    public void example3() {
        int n = 2;
        int m = 2;
        int[][] sources = UtUtils.stringToInts2("[[1,1,5]]");
        int[][] expected = UtUtils.stringToInts2("[[5,5],[5,5]]");
        Assertions.assertArrayEquals(expected, solution3905.colorGrid(n, m, sources));
    }
}