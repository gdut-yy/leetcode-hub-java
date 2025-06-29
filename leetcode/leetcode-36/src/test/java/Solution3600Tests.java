import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3600Tests {
    private final Solution3600 solution3600 = new Solution3600();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2,1],[1,2,3,0]]");
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3600.maxStability(n, edges, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,4,0],[1,2,3,0],[0,2,1,0]]");
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution3600.maxStability(n, edges, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1,1],[1,2,1,1],[2,0,1,1]]");
        int k = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution3600.maxStability(n, edges, k));
    }
}