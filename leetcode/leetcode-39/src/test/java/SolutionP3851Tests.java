import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3851Tests {
    private final SolutionP3851 solutionP3851 = new SolutionP3851();

    @Test
    public void example1() {
        int[][] requests = UtUtils.stringToInts2("[[1,1],[2,1],[1,7],[2,8]]");
        int k = 1;
        int window = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3851.maxRequests(requests, k, window));
    }

    @Test
    public void example2() {
        int[][] requests = UtUtils.stringToInts2("[[1,2],[1,5],[1,2],[1,6]]");
        int k = 2;
        int window = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3851.maxRequests(requests, k, window));
    }

    @Test
    public void example3() {
        int[][] requests = UtUtils.stringToInts2("[[1,1],[2,5],[1,2],[3,9]]");
        int k = 1;
        int window = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3851.maxRequests(requests, k, window));
    }
}
