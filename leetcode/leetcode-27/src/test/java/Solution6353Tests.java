import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6353Tests {
    private final Solution6353 solution6353 = new Solution6353();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6353.minimumVisitedCells(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6353.minimumVisitedCells(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[2,1,0],[1,0,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution6353.minimumVisitedCells(grid));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/422608328/
        // O(mn(m+n)) 解法 TLE
        int[][] grid = UtUtils.loadingInts2("solution6353-example4-input.txt", 0);
        int expected = 2;
        Assertions.assertEquals(expected, solution6353.minimumVisitedCells(grid));
    }
}