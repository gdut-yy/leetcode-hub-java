import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6473Tests {
    private final Solution6473 solution6473 = new Solution6473();

    @Test
    public void example1() {
        int[] nums1 = {4, 3, 1, 2};
        int[] nums2 = {2, 4, 9, 5};
        int[][] queries = UtUtils.stringToInts2("[[4,1],[1,3],[2,5]]");
        int[] expected = {6, 10, 7};
        Assertions.assertArrayEquals(expected, solution6473.maximumSumQueries(nums1, nums2, queries));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 2, 5};
        int[] nums2 = {2, 3, 4};
        int[][] queries = UtUtils.stringToInts2("[[4,4],[3,2],[1,1]]");
        int[] expected = {9, 9, 9};
        Assertions.assertArrayEquals(expected, solution6473.maximumSumQueries(nums1, nums2, queries));
    }

    @Test
    public void example3() {
        int[] nums1 = {2, 1};
        int[] nums2 = {2, 3};
        int[][] queries = UtUtils.stringToInts2("[[3,3]]");
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution6473.maximumSumQueries(nums1, nums2, queries));
    }
}