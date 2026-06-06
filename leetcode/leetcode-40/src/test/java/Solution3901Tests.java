import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3901Tests {
    private final Solution3901 solution3901 = new Solution3901();

    @Test
    public void example1() {
        int[] nums = {4, 8, 12, 16};
        int p = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,3],[2,6]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3901.countGoodSubseq(nums, p, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 7, 8};
        int p = 3;
        int[][] queries = UtUtils.stringToInts2("[[0,6],[1,9],[2,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3901.countGoodSubseq(nums, p, queries));
    }

    @Test
    public void example3() {
        int[] nums = {5, 7, 9};
        int p = 2;
        int[][] queries = UtUtils.stringToInts2("[[1,4],[2,8]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3901.countGoodSubseq(nums, p, queries));
    }
}