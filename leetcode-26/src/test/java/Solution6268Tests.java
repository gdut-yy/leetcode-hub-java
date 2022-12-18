import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6268Tests {
    private final Solution6268 solution6268 = new Solution6268();

    @Test
    public void example1() {
        int n = 3;
        int[][] queries = UtUtils.stringToInts2("[[5,3],[4,7],[2,3]]");
        int[] expected = {4, 5, 3};
        Assertions.assertArrayEquals(expected, solution6268.cycleLengthQueries(n, queries));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] queries = UtUtils.stringToInts2("[[1,2]]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution6268.cycleLengthQueries(n, queries));
    }
}
