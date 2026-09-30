import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3078Tests {
    private final SolutionP3078 solutionP3078 = new SolutionP3078();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[1,2,2],[2,2,3],[2,3,3]]");
        String[] pattern = {"ab", "bb"};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solutionP3078.findPattern(board, pattern));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[1,1,2],[3,3,4],[6,6,6]]");
        String[] pattern = {"ab", "66"};
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solutionP3078.findPattern(board, pattern));
    }

    @Test
    public void example3() {
        int[][] board = UtUtils.stringToInts2("[[1,2],[2,1]]");
        String[] pattern = {"xx"};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solutionP3078.findPattern(board, pattern));
    }
}
