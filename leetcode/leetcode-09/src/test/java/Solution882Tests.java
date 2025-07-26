import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution882Tests {
    private final Solution882 solution882 = new Solution882();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[0,2,1],[1,2,2]]");
        int maxMoves = 6;
        int n = 3;
        int expected = 13;
        Assertions.assertEquals(expected, solution882.reachableNodes(edges, maxMoves, n));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[1,2,6],[0,2,8],[1,3,1]]");
        int maxMoves = 10;
        int n = 4;
        int expected = 23;
        Assertions.assertEquals(expected, solution882.reachableNodes(edges, maxMoves, n));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]]");
        int maxMoves = 17;
        int n = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution882.reachableNodes(edges, maxMoves, n));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/submissions/647044959/
        int[][] edges = UtUtils.stringToInts2("[]");
        int maxMoves = 1000000000;
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution882.reachableNodes(edges, maxMoves, n));
    }
}