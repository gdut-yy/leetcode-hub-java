import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR129Tests {
    private final SolutionLCR129 solutionLCR129 = new SolutionLCR129();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
                """);
        String word = "ABCCED";
        Assertions.assertTrue(solutionLCR129.wordPuzzle(board, word));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["a","b"],["c","d"]]
                """);
        String word = "abcd";
        Assertions.assertFalse(solutionLCR129.wordPuzzle(board, word));
    }
}
