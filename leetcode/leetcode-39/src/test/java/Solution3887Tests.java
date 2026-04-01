import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3887Tests {
    private final Solution3887 solution3887 = new Solution3887();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[0,2,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3887.numberOfEdgesAdded(n, edges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[0,2,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3887.numberOfEdgesAdded(n, edges));
    }
}