import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3112Tests {
    private final Solution3112 solution3112 = new Solution3112();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,1],[0,2,4]]");
        int[] disappear = {1, 1, 5};
        int[] expected = {0, -1, 4};
        Assertions.assertArrayEquals(expected, solution3112.minimumTime(n, edges, disappear));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,1],[0,2,4]]");
        int[] disappear = {1, 3, 5};
        int[] expected = {0, 2, 3};
        Assertions.assertArrayEquals(expected, solution3112.minimumTime(n, edges, disappear));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1]]");
        int[] disappear = {1, 1};
        int[] expected = {0, -1};
        Assertions.assertArrayEquals(expected, solution3112.minimumTime(n, edges, disappear));
    }
}