import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3593Tests {
    private final Solution3593 solution3593 = new Solution3593();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] cost = {2, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3593.minIncrease(n, edges, cost));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] cost = {5, 1, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3593.minIncrease(n, edges, cost));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,4],[0,1],[1,2],[1,3]]");
        int[] cost = {3, 4, 1, 1, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution3593.minIncrease(n, edges, cost));
    }
}