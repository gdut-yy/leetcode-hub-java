import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4027Tests {
    private final Solution4027 solution4027 = new Solution4027();

    @Test
    public void example1() {
        int n = 9;
        int start = 0;
        int[][] requests = UtUtils.stringToInts2("[[0,8],[6,5]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution4027.elevatorRequests(n, start, requests));
    }

    @Test
    public void example2() {
        int n = 8;
        int start = 5;
        int[][] requests = UtUtils.stringToInts2("[[1,7],[7,3]]");
        long expected = 7;
        Assertions.assertEquals(expected, solution4027.elevatorRequests(n, start, requests));
    }

    @Test
    public void example3() {
        int n = 7;
        int start = 3;
        int[][] requests = UtUtils.stringToInts2("[[0,5],[0,1],[6,3]]");
        long expected = 8;
        Assertions.assertEquals(expected, solution4027.elevatorRequests(n, start, requests));
    }
}