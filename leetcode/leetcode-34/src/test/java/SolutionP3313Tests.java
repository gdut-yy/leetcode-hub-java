import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3313Tests {
    private final SolutionP3313 solutionP3313 = new SolutionP3313();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] expected = {2, 2, 1};
        Assertions.assertArrayEquals(expected, solutionP3313.lastMarkedNodes(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solutionP3313.lastMarkedNodes(edges));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        int[] expected = {3, 3, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solutionP3313.lastMarkedNodes(edges));
    }
}