import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP15Tests {
    private final SolutionLCP15 solutionLCP15 = new SolutionLCP15();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,4],[3,2],[2,1]]");
        String direction = "LL";
        // [0,2,1,3] 是符合"LL"的方案之一。
//        int[] expected = {0, 2, 1, 3};
        int[] expected = {0, 3, 2, 1};
        Assertions.assertArrayEquals(expected, solutionLCP15.visitOrder(points, direction));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,3],[2,4],[3,3],[2,1]]");
        String direction = "LR";
        int[] expected = {0, 3, 1, 2};
        Assertions.assertArrayEquals(expected, solutionLCP15.visitOrder(points, direction));
    }
}