import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3777Tests {
    private final Solution3777 solution3777 = new Solution3777();

    @Test
    public void example1() {
        String s = "ABA";
        int[][] queries = UtUtils.stringToInts2("[[2,1,2],[1,1],[2,0,2]]");
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution3777.minDeletions(s, queries));
    }

    @Test
    public void example2() {
        String s = "ABB";
        int[][] queries = UtUtils.stringToInts2("[[2,0,2],[1,2],[2,0,2]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution3777.minDeletions(s, queries));
    }

    @Test
    public void example3() {
        String s = "BABA";
        int[][] queries = UtUtils.stringToInts2("[[2,0,3],[1,1],[2,1,3]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3777.minDeletions(s, queries));
    }
}