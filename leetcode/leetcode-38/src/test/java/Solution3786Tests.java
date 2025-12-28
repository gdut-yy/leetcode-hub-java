import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3786Tests {
    private final Solution3786 solution3786 = new Solution3786();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] group = {1, 1, 1};
        long expected = 4;
        Assertions.assertEquals(expected, solution3786.interactionCosts(n, edges, group));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] group = {3, 2, 3};
        long expected = 2;
        Assertions.assertEquals(expected, solution3786.interactionCosts(n, edges, group));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int[] group = {1, 1, 4, 4};
        long expected = 3;
        Assertions.assertEquals(expected, solution3786.interactionCosts(n, edges, group));
    }

    @Test
    public void example4() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] group = {9, 8};
        long expected = 0;
        Assertions.assertEquals(expected, solution3786.interactionCosts(n, edges, group));
    }
}