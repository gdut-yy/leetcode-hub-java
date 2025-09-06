import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3476Tests {
    private final SolutionP3476 solutionP3476 = new SolutionP3476();

    @Test
    public void example1() {
        int[] workers = {1, 2, 3, 4, 5};
        int[][] tasks = UtUtils.stringToInts2("[[1,100],[2,400],[3,100],[3,400]]");
        long expected = 1000;
        Assertions.assertEquals(expected, solutionP3476.maxProfit(workers, tasks));
    }

    @Test
    public void example2() {
        int[] workers = {10, 10000, 100000000};
        int[][] tasks = UtUtils.stringToInts2("[[1,100]]");
        long expected = 100;
        Assertions.assertEquals(expected, solutionP3476.maxProfit(workers, tasks));
    }

    @Test
    public void example3() {
        int[] workers = {7};
        int[][] tasks = UtUtils.stringToInts2("[[3,3],[3,3]]");
        long expected = 3;
        Assertions.assertEquals(expected, solutionP3476.maxProfit(workers, tasks));
    }
}