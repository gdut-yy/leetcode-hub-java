import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP32Tests {
    private final SolutionLCP32 solutionLCP32 = new SolutionLCP32();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[1,3,2],[2,5,3],[5,6,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[2,3,1],[5,5,1],[5,6,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
    }
}
