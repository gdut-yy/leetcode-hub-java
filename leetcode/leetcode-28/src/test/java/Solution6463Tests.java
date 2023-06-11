import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6463Tests {
    private final Solution6463 solution6463 = new Solution6463();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[0,0,0,1],[1,1,1,1]]");
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution6463.goodSubsetofBinaryMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0]]");
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution6463.goodSubsetofBinaryMatrix(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution6463.goodSubsetofBinaryMatrix(grid));
    }
}