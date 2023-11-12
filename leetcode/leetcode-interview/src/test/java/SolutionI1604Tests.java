import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1604Tests {
    private final SolutionI1604 solutionI1604 = new SolutionI1604();

    @Test
    public void example1() {
        String[] board = {"O X", " XO", "X O"};
        String expected = "X";
        Assertions.assertEquals(expected, solutionI1604.tictactoe(board));
    }

    @Test
    public void example2() {
        String[] board = {"OOX", "XXO", "OXO"};
        String expected = "Draw";
        Assertions.assertEquals(expected, solutionI1604.tictactoe(board));
    }

    @Test
    public void example3() {
        String[] board = {"OOX", "XXO", "OX "};
        String expected = "Pending";
        Assertions.assertEquals(expected, solutionI1604.tictactoe(board));
    }
}