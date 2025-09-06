import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3323Tests {
    private final SolutionP3323 solutionP3323 = new SolutionP3323();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[5,6],[8,10]]");
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3323.minConnectedGroups(intervals, k));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[5,10],[1,1],[3,3]]");
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3323.minConnectedGroups(intervals, k));
    }
}