import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class Solution2610Tests {
    private final Solution2610 solution2610 = new Solution2610();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3,4,2],[1,3],[1]]");
        List<List<Integer>> actual = solution2610.findMatrix(nums);
        check(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,3,2,1]]");
        List<List<Integer>> actual = solution2610.findMatrix(nums);
        check(expected, actual);
    }

    private void check(List<List<Integer>> a, List<List<Integer>> b) {
        for (List<Integer> list : a) Collections.sort(list);
        for (List<Integer> list : b) Collections.sort(list);
        a.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        b.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(a, b);
    }
}