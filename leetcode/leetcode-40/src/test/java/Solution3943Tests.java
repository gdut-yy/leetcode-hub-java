import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3943Tests {
    private final Solution3943 solution3943 = new Solution3943();

    @Test
    public void example1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[][] queries = UtUtils.stringToInts2("[[2,5],[1,0,0,2],[2,5]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution3943.numberOfPairs(nums1, nums2, queries));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2, 3};
        int[][] queries = UtUtils.stringToInts2("[[2,4],[1,0,1,1],[2,4]]");
        int[] expected = {2, 6};
        Assertions.assertArrayEquals(expected, solution3943.numberOfPairs(nums1, nums2, queries));
    }

    @Test
    public void example3() {
        int[] nums1 = {2, 5, 8, 4};
        int[] nums2 = {1, 3, 8};
        int[][] queries = UtUtils.stringToInts2("[[2,9],[1,1,2,1],[2,10]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution3943.numberOfPairs(nums1, nums2, queries));
    }
}