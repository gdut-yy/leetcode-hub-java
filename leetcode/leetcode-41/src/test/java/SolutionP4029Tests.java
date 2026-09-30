import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4029Tests {
    private final SolutionP4029 solutionP4029 = new SolutionP4029();

    @Test
    public void example1() {
        int n = 9;
        int start = 0;
        int[][] requests = UtUtils.stringToInts2("[[0,8],[6,5]]");
        long expected = 9;
        Assertions.assertEquals(expected, solutionP4029.elevatorRequests(n, start, requests));
    }

    @Test
    public void example2() {
        int n = 8;
        int start = 5;
        int[][] requests = UtUtils.stringToInts2("[[1,7],[7,3]]");
        long expected = 7;
        Assertions.assertEquals(expected, solutionP4029.elevatorRequests(n, start, requests));
    }

    @Test
    public void example3() {
        int n = 7;
        int start = 3;
        int[][] requests = UtUtils.stringToInts2("[[0,5],[0,1],[6,3]]");
        long expected = 8;
        Assertions.assertEquals(expected, solutionP4029.elevatorRequests(n, start, requests));
    }
}
