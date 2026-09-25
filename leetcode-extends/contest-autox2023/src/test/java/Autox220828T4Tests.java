import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Autox220828T4Tests {
    private final Autox220828T4 autox220828T4 = new Autox220828T4();

    @Test
    public void example1() {
        int[][] geometry = UtUtils.stringToInts2("[[2,5,7,3],[1,1,4,2],[4,3,2]]");
        int[][] path = UtUtils.stringToInts2("[[0,1],[1,2],[0,2]]");
        boolean[] expected = {true, true, true};
        Assertions.assertArrayEquals(expected, autox220828T4.antPass(geometry, path));
    }

    @Test
    public void example2() {
        int[][] geometry = UtUtils.stringToInts2("[[4,1,1],[3,2,1],[1,4,5,4]]");
        int[][] path = UtUtils.stringToInts2("[[0,1],[2,0]]");
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, autox220828T4.antPass(geometry, path));
    }
}
