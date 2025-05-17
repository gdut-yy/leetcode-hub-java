import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3544Tests {
    private final Solution3544 solution3544 = new Solution3544();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        int[] nums = {4, -8, -6, 3, 7, -2, 5};
        int k = 2;
        int expected = 27;
        Assertions.assertEquals(expected, solution3544.subtreeInversionSum(edges, nums, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4]]");
        int[] nums = {-1, 3, -2, 4, -5};
        int k = 2;
        int expected = 9;
        Assertions.assertEquals(expected, solution3544.subtreeInversionSum(edges, nums, k));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] nums = {0, -1, -2};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3544.subtreeInversionSum(edges, nums, k));
    }
}