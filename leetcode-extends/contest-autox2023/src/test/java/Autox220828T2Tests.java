import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Autox220828T2Tests {
    private final Autox220828T2 autox220828T2 = new Autox220828T2();

    @Test
    public void example1() {
        int[][] handle = UtUtils.stringToInts2("[[1,1],[1,2],[1,3],[1,2],[3],[4],[2,1],[2,2],[2,3],[3],[4]]");
        double[] expected = {2.00000, 0.50000, 2.00000, 0.00000};
        Assertions.assertArrayEquals(expected, autox220828T2.honeyQuotes(handle), 1e-5);
    }

    @Test
    public void example2() {
        int[][] handle = UtUtils.stringToInts2("[[3],[1,10],[1,0],[3],[4],[2,10],[3]]");
        double[] expected = {-1.00000, 5.00000, 25.00000, 0.00000};
        Assertions.assertArrayEquals(expected, autox220828T2.honeyQuotes(handle), 1e-5);
    }
}
