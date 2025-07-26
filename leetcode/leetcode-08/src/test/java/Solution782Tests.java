import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution782Tests {
    private final Solution782.V1 solution782_v1 = new Solution782.V1();
    private final Solution782.V2 solution782_v2 = new Solution782.V2();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution782_v1.movesToChessboard(board));
        Assertions.assertEquals(expected, solution782_v2.movesToChessboard(board));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[0, 1], [1, 0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution782_v1.movesToChessboard(board));
        Assertions.assertEquals(expected, solution782_v2.movesToChessboard(board));
    }

    @Test
    public void example3() {
        int[][] board = UtUtils.stringToInts2("[[1, 0], [1, 0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution782_v1.movesToChessboard(board));
        Assertions.assertEquals(expected, solution782_v2.movesToChessboard(board));
    }
}