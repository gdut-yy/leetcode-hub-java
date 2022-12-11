import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP21Tests {
    private final SolutionLCP21 solutionLCP21 = new SolutionLCP21();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,1],[2,5],[5,6]]");
        int startA = 3;
        int startB = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP21.chaseGame(edges, startA, startB));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,1]]");
        int startA = 1;
        int startB = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP21.chaseGame(edges, startA, startB));
    }
}
