import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1059Tests {
    private final Solution1059 solution1059 = new Solution1059();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int source = 0;
        int destination = 2;
        Assertions.assertFalse(solution1059.leadsToDestination(n, edges, source, destination));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int source = 0;
        int destination = 3;
        Assertions.assertFalse(solution1059.leadsToDestination(n, edges, source, destination));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,3]]");
        int source = 0;
        int destination = 3;
        Assertions.assertTrue(solution1059.leadsToDestination(n, edges, source, destination));
    }
}