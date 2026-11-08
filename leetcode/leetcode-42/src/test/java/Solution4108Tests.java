import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4108Tests {
    private final Solution4108 solution4108 = new Solution4108();

    @Test
    public void example1() {
        int n = 3;
        String colors = "RBR";
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        long expected = 1;
        Assertions.assertEquals(expected, solution4108.minCost(n, colors, edges));
    }

    @Test
    public void example2() {
        int n = 3;
        String colors = "RBR";
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution4108.minCost(n, colors, edges));
    }

    @Test
    public void example3() {
        int n = 4;
        String colors = "BRRR";
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution4108.minCost(n, colors, edges));
    }

    @Test
    public void example4() {
        int n = 3;
        String colors = "BBB";
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution4108.minCost(n, colors, edges));
    }
}
