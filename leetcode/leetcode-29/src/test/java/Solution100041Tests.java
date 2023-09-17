import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100041Tests {
    private final Solution100041 solution100041 = new Solution100041();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[2,0],[2,1],[1,3]]");
        int[] expected = {1, 1, 0, 2};
        Assertions.assertArrayEquals(expected, solution100041.minEdgeReversals(n, edges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,0]]");
        int[] expected = {2, 0, 1};
        Assertions.assertArrayEquals(expected, solution100041.minEdgeReversals(n, edges));
    }
}