import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZjFuture220708T2Tests {
    private final ZjFuture220708T2 zjFuture220708T2 = new ZjFuture220708T2();

    @Test
    public void example1() {
        int[] chess = {1, 0, 1, 0, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, zjFuture220708T2.minSwaps(chess));
    }

    @Test
    public void example2() {
        int[] chess = {0, 0, 0, 1, 0};
        int expected = 0;
        Assertions.assertEquals(expected, zjFuture220708T2.minSwaps(chess));
    }

    @Test
    public void example3() {
        int[] chess = {1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, zjFuture220708T2.minSwaps(chess));
    }
}
