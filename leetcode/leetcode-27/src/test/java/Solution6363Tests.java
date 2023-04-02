import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class Solution6363Tests {
    private final Solution6363 solution6363 = new Solution6363();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3,4,2],[1,3],[1]]");
        List<List<Integer>> actual = solution6363.findMatrix(nums);
        check(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,3,2,1]]");
        List<List<Integer>> actual = solution6363.findMatrix(nums);
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