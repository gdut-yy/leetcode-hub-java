import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution130Tests {
    private final Solution130 solution130 = new Solution130();

    @Test
    public void example1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        solution130.solve(board);
        Assertions.assertArrayEquals(expected, board);
    }

    @Test
    public void example2() {
        char[][] board = {{'X'}};
        char[][] expected = {{'X'}};
        solution130.solve(board);
        Assertions.assertArrayEquals(expected, board);
    }

    // 补充用例
    @Test
    public void example3() {
        char[][] board = {{'O', 'O'}, {'O', 'O'}};
        char[][] expected = {{'O', 'O'}, {'O', 'O'}};
        solution130.solve(board);
        Assertions.assertArrayEquals(expected, board);
    }
}
