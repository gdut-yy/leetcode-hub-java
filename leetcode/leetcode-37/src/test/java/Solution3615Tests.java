import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3615Tests {
    private final Solution3615 solution3615 = new Solution3615();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        String label = "aba";
        int expected = 3;
        Assertions.assertEquals(expected, solution3615.maxLen(n, edges, label));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        String label = "abc";
        int expected = 1;
        Assertions.assertEquals(expected, solution3615.maxLen(n, edges, label));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,2],[0,3],[3,1]]");
        String label = "bbac";
        int expected = 3;
        Assertions.assertEquals(expected, solution3615.maxLen(n, edges, label));
    }
}