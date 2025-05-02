import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3525Tests {
    private final Solution3525 solution3525 = new Solution3525();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int[][] queries = UtUtils.stringToInts2("[[2,2,0,2],[3,3,3,0],[0,1,0,1]]");
        int[] expected = {2, 2, 2};
        Assertions.assertArrayEquals(expected, solution3525.resultArray(nums, k, queries));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 8, 16, 32};
        int k = 4;
        int[][] queries = UtUtils.stringToInts2("[[0,2,0,2],[0,2,0,1]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution3525.resultArray(nums, k, queries));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 2;
        int[][] queries = UtUtils.stringToInts2("[[2,1,0,1]]");
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, solution3525.resultArray(nums, k, queries));
    }
}