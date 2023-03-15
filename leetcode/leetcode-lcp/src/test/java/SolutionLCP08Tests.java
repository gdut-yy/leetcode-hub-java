import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP08Tests {
    private final SolutionLCP08 solutionLCP08 = new SolutionLCP08();

    @Test
    public void example1() {
        int[][] increase = UtUtils.stringToInts2("[[2,8,4],[2,5,0],[10,9,8]]");
        int[][] requirements = UtUtils.stringToInts2("[[2,11,3],[15,10,7],[9,17,12],[8,1,14]]");
        int[] expected = {2, -1, 3, -1};
        Assertions.assertArrayEquals(expected, solutionLCP08.getTriggerTime(increase, requirements));
    }

    @Test
    public void example2() {
        int[][] increase = UtUtils.stringToInts2("[[0,4,5],[4,8,8],[8,6,1],[10,10,0]]");
        int[][] requirements = UtUtils.stringToInts2("[[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]");
        int[] expected = {-1, 4, 3, 3, 3};
        Assertions.assertArrayEquals(expected, solutionLCP08.getTriggerTime(increase, requirements));
    }

    @Test
    public void example3() {
        int[][] increase = UtUtils.stringToInts2("[[1,1,1]]");
        int[][] requirements = UtUtils.stringToInts2("[[0,0,0]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionLCP08.getTriggerTime(increase, requirements));
    }
}
