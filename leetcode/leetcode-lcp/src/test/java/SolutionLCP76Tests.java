import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP76Tests {
    private final SolutionLCP76 solutionLCP76 = new SolutionLCP76();

    @Test
    public void example1() {
        int n = 3;
        int m = 3;
        String[] chessboard = {"..R", "..B", "?R?"};
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP76.getSchemeCount(n, m, chessboard));
    }

    @Test
    public void example2() {
        int n = 3;
        int m = 3;
        String[] chessboard = {"?R?", "B?B", "?R?"};
        int expected = 105;
        Assertions.assertEquals(expected, solutionLCP76.getSchemeCount(n, m, chessboard));
    }
}