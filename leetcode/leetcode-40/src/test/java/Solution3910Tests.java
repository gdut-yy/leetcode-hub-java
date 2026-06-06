import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3910Tests {
    private final Solution3910 solution3910 = new Solution3910();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3910.evenSumSubgraphs(nums, edges));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int[][] edges = UtUtils.stringToInts2("[]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3910.evenSumSubgraphs(nums, edges));
    }
}