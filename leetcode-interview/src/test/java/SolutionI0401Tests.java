import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0401Tests {
    private final SolutionI0401 solutionI0401 = new SolutionI0401();

    @Test
    public void example1() {
        int n = 3;
        int[][] graph = UtUtils.stringToInts2("[[0, 1], [0, 2], [1, 2], [1, 2]]");
        int start = 0;
        int target = 2;
        Assertions.assertTrue(solutionI0401.findWhetherExistsPath(n, graph, start, target));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] graph = UtUtils.stringToInts2("[[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]]");
        int start = 0;
        int target = 4;
        Assertions.assertTrue(solutionI0401.findWhetherExistsPath(n, graph, start, target));
    }
}
