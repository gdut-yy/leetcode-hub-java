import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3820Tests {
    private final Solution3820 solution3820 = new Solution3820();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int x = 1;
        int y = 2;
        int z = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3820.specialNodes(n, edges, x, y, z));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int x = 0;
        int y = 3;
        int z = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3820.specialNodes(n, edges, x, y, z));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3]]");
        int x = 1;
        int y = 3;
        int z = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution3820.specialNodes(n, edges, x, y, z));
    }
}