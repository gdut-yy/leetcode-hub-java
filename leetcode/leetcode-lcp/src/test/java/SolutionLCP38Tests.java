import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP38Tests {
    private final SolutionLCP38 solutionLCP38 = new SolutionLCP38();

    @Test
    public void example1() {
        String[] grid = {"S.C.P#P.", ".....#.S"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP38.guardCastle(grid));
    }

    @Test
    public void example2() {
        String[] grid = {"SP#P..P#PC#.S", "..#P..P####.#"};
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP38.guardCastle(grid));
    }

    @Test
    public void example3() {
        String[] grid = {"SP#.C.#PS", "P.#...#.P"};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP38.guardCastle(grid));
    }

    @Test
    public void example4() {
        String[] grid = {"CP.#.P.", "...S..S"};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP38.guardCastle(grid));
    }
}