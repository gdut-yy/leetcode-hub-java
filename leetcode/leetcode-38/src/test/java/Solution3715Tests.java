import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3715Tests {
    private final Solution3715 solution3715 = new Solution3715();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] nums = {2, 8, 2};
        long expected = 3;
        Assertions.assertEquals(expected, solution3715.sumOfAncestors(n, edges, nums));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] nums = {1, 2, 4};
        long expected = 1;
        Assertions.assertEquals(expected, solution3715.sumOfAncestors(n, edges, nums));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3]]");
        int[] nums = {1, 2, 9, 4};
        long expected = 2;
        Assertions.assertEquals(expected, solution3715.sumOfAncestors(n, edges, nums));
    }
}