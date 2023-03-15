import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution562Tests {
    private final Solution562 solution562 = new Solution562();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,0],[0,0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution562.longestLine(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,1,1,1],[0,1,1,0],[0,0,0,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution562.longestLine(mat));
    }
}
