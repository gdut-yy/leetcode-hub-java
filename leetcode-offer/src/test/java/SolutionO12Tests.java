import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO12Tests {
    private final SolutionO12 solutionO12 = new SolutionO12();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
                """);
        String word = "ABCCED";
        Assertions.assertTrue(solutionO12.exist(board, word));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["a","b"],["c","d"]]
                """);
        String word = "abcd";
        Assertions.assertFalse(solutionO12.exist(board, word));
    }
}
