import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP55Tests {
    private final SolutionLCP55 solutionLCP55 = new SolutionLCP55();

    @Test
    public void example1() {
        int[] time = {2, 3, 2};
        int[][] fruits = UtUtils.stringToInts2("[[0,2],[1,4],[2,1]]");
        int limit = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solutionLCP55.getMinimumTime(time, fruits, limit));
    }

    @Test
    public void example2() {
        int[] time = {1};
        int[][] fruits = UtUtils.stringToInts2("[[0,3],[0,5]]");
        int limit = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP55.getMinimumTime(time, fruits, limit));
    }
}
