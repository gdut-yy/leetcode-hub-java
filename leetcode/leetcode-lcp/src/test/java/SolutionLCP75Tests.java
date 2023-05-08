import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP75Tests {
    private final SolutionLCP75 solutionLCP75 = new SolutionLCP75();

    @Test
    public void example1() {
        String[] maze = {".....", "##S..", "...#.", "T.#..", "###.."};
        int expected = 7;
        Assertions.assertEquals(expected, solutionLCP75.challengeOfTheKeeper(maze));
    }

    @Test
    public void example2() {
        String[] maze = {".#..", "..##", ".#S.", ".#.T"};
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP75.challengeOfTheKeeper(maze));
    }

    @Test
    public void example3() {
        String[] maze = {"S###.", "..###", "#..##", "##..#", "###.T"};
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP75.challengeOfTheKeeper(maze));
    }
}