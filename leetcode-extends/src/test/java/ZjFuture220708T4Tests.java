import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZjFuture220708T4Tests {
    private final ZjFuture220708T4 zjFuture220708T4 = new ZjFuture220708T4();

    @Test
    public void example1() {
        int[][] distributions = UtUtils.stringToInts2("[[0,1,5],[1,2,10],[2,0,5],[2,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, zjFuture220708T4.minTransfers(distributions));
    }

    @Test
    public void example2() {
        int[][] distributions = UtUtils.stringToInts2("[[0,1,5],[1,4,5],[4,0,5]]");
        int expected = 0;
        Assertions.assertEquals(expected, zjFuture220708T4.minTransfers(distributions));
    }
}
