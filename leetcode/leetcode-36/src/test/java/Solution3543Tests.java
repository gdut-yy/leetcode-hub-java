import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3543Tests {
    private final Solution3543 solution3543 = new Solution3543();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,2]]");
        int k = 2;
        int t = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3543.maxWeight(n, edges, k, t));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[0,2,3]]");
        int k = 1;
        int t = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3543.maxWeight(n, edges, k, t));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,6],[1,2,8]]");
        int k = 1;
        int t = 6;
        int expected = -1;
        Assertions.assertEquals(expected, solution3543.maxWeight(n, edges, k, t));
    }
}