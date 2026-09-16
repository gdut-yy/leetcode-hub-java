import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4017Tests {
    private final Solution4017 solution4017 = new Solution4017();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4};
        int[][] queries = UtUtils.stringToInts2("[[1,0,3],[2,1,1],[1,0,3]]");
        long[] expected = {2, 0};
        Assertions.assertArrayEquals(expected, solution4017.countOfPeaks(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {9, 8, 9, 8};
        int[][] queries = UtUtils.stringToInts2("[[1,1,3],[2,2,1],[1,0,2]]");
        long[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution4017.countOfPeaks(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {3, 6, 2, 7, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,1,3],[2,3,0],[1,0,4]]");
        long[] expected = {0, 3};
        Assertions.assertArrayEquals(expected, solution4017.countOfPeaks(nums, queries));
    }
}