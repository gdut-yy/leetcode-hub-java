import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3965Tests {
    private final Solution3965 solution = new Solution3965();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] baseTime = {9, 5, 3};
        long expected = 17;
        Assertions.assertEquals(expected, solution.finishTime(n, edges, baseTime));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] baseTime = {4, 7, 6};
        long expected = 12;
        Assertions.assertEquals(expected, solution.finishTime(n, edges, baseTime));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3]]");
        int[] baseTime = {5, 8, 2, 1};
        long expected = 18;
        Assertions.assertEquals(expected, solution.finishTime(n, edges, baseTime));
    }
}