import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1284Tests {
    private final Solution1284 solution1284 = new Solution1284();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1284.minFlips(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1284.minFlips(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[1,0,0],[1,0,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1284.minFlips(mat));
    }
}
