import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3419Tests {
    private final Solution3419 solution3419 = new Solution3419();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,0,1],[2,0,2],[3,0,1],[4,3,1],[2,1,1]]");
        int threshold = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3419.minMaxWeight(n, edges, threshold));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[0,2,2],[0,3,1],[0,4,1],[1,2,1],[1,4,1]]");
        int threshold = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3419.minMaxWeight(n, edges, threshold));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,2,1],[1,3,3],[1,4,5],[2,3,2],[3,4,2],[4,0,1]]");
        int threshold = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3419.minMaxWeight(n, edges, threshold));
    }

    @Test
    public void example4() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,2,1],[1,3,3],[1,4,5],[2,3,2],[4,0,1]]");
        int threshold = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3419.minMaxWeight(n, edges, threshold));
    }
}