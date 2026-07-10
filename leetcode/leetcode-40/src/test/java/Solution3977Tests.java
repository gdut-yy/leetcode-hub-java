import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3977Tests {
    private final Solution3977 solution3977 = new Solution3977();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,4,1],[0,2,1],[2,3,1],[3,4,1]]");
        int power = 4;
        int[] cost = {2, 3, 1, 1, 1};
        int source = 0;
        int target = 4;
        long[] expected = {3, 0};
        Assertions.assertArrayEquals(expected, solution3977.minTimeMaxPower(n, edges, power, cost, source, target));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,2],[2,0,2]]");
        int power = 3;
        int[] cost = {1, 1, 1};
        int source = 1;
        int target = 1;
        long[] expected = {0, 3};
        Assertions.assertArrayEquals(expected, solution3977.minTimeMaxPower(n, edges, power, cost, source, target));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,3],[2,3,4]]");
        int power = 3;
        int[] cost = {1, 1, 1, 1};
        int source = 0;
        int target = 3;
        long[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3977.minTimeMaxPower(n, edges, power, cost, source, target));
    }
}