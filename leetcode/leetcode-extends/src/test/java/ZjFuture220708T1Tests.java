import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZjFuture220708T1Tests {
    private final ZjFuture220708T1 zjFuture220708T1 = new ZjFuture220708T1();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[0,40],[10,15],[20,30]]");
        Assertions.assertFalse(zjFuture220708T1.canReceiveAllSignals(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[2,8],[8,14]]");
        Assertions.assertTrue(zjFuture220708T1.canReceiveAllSignals(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[[9,12],[2,3]]");
        Assertions.assertTrue(zjFuture220708T1.canReceiveAllSignals(intervals));
    }
}

