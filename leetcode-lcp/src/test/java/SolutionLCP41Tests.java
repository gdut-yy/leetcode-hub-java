import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP41Tests {
    private final SolutionLCP41 solutionLCP41 = new SolutionLCP41();

    @Test
    public void example1() {
        String[] chessboard = {"....X.", "....X.", "XOOO..", "......", "......"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP41.flipChess(chessboard));
    }

    @Test
    public void example2() {
        String[] chessboard = {".X.", ".O.", "XO."};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP41.flipChess(chessboard));
    }

    @Test
    public void example3() {
        String[] chessboard = {".......", ".......", ".......", "X......", ".O.....", "..O....", "....OOX"};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP41.flipChess(chessboard));
    }
}
