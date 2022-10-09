import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6200Tests {
    private final Solution6200 solution6200 = new Solution6200();

    @Test
    public void example1() {
        int n = 10;
        int[][] logs = UtUtils.stringToInts2("[[0,3],[2,5],[0,9],[1,15]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6200.hardestWorker(n, logs));
    }

    @Test
    public void example2() {
        int n = 26;
        int[][] logs = UtUtils.stringToInts2("[[1,1],[3,7],[2,12],[7,17]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6200.hardestWorker(n, logs));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] logs = UtUtils.stringToInts2("[[0,10],[1,20]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution6200.hardestWorker(n, logs));
    }
}
