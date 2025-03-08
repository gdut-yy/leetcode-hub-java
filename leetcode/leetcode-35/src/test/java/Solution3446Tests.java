import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3446Tests {
    private final Solution3446.V1 solution3446_v1 = new Solution3446.V1();
    private final Solution3446.V2 solution3446_v2 = new Solution3446.V2();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,7,3],[9,8,2],[4,5,6]]");
        int[][] expected = UtUtils.stringToInts2("[[8,2,3],[9,6,7],[4,5,1]]");
        Assertions.assertArrayEquals(expected, solution3446_v1.sortMatrix(grid));
        Assertions.assertArrayEquals(expected, solution3446_v2.sortMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[][] expected = UtUtils.stringToInts2("[[2,1],[1,0]]");
        Assertions.assertArrayEquals(expected, solution3446_v1.sortMatrix(grid));
        Assertions.assertArrayEquals(expected, solution3446_v2.sortMatrix(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int[][] expected = UtUtils.stringToInts2("[[1]]");
        Assertions.assertArrayEquals(expected, solution3446_v1.sortMatrix(grid));
        Assertions.assertArrayEquals(expected, solution3446_v2.sortMatrix(grid));
    }
}