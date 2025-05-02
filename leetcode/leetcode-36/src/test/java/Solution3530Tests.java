import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3530Tests {
    private final Solution3530 solution3530 = new Solution3530();

    @Test
    public void example1() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] score = {2, 3};
        int expected = 8;
        Assertions.assertEquals(expected, solution3530.maxProfit(n, edges, score));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] score = {1, 6, 3};
        int expected = 25;
        Assertions.assertEquals(expected, solution3530.maxProfit(n, edges, score));
    }
}