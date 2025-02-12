import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3417Tests {
    private final Solution3417 solution3417 = new Solution3417();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        List<Integer> expected = List.of(1, 4);
        Assertions.assertEquals(expected, solution3417.zigzagTraversal(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[2,1],[2,1],[2,1]]");
        List<Integer> expected = List.of(2, 1, 2);
        Assertions.assertEquals(expected, solution3417.zigzagTraversal(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        List<Integer> expected = List.of(1, 3, 5, 7, 9);
        Assertions.assertEquals(expected, solution3417.zigzagTraversal(grid));
    }
}