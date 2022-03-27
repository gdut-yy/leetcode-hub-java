import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution5268Tests {
    private final Solution5268 solution5268 = new Solution5268();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 6));
        List<List<Integer>> actual = solution5268.findDifference(nums1, nums2);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList());
        List<List<Integer>> actual = solution5268.findDifference(nums1, nums2);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
