import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZjFuture220708T3Tests {
    private final ZjFuture220708T3 zjFuture220708T3 = new ZjFuture220708T3();

    @Test
    public void example1() {
        int[][] area = UtUtils.stringToInts2("[[0,1,0,0,0],[0,0,0,0,1],[0,0,1,0,0]]");
        int expected = 5;
        Assertions.assertEquals(expected, zjFuture220708T3.buildTransferStation(area));
    }

    @Test
    public void example2() {
        int[][] area = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, zjFuture220708T3.buildTransferStation(area));
    }
}
