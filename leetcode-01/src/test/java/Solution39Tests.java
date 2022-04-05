import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution39Tests {
    private final Solution39 solution39 = new Solution39();

    @Test
    public void example1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,3],[7]]");
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,2,2],[2,3,3],[3,5]]");
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        int[] candidates = {1};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1, 1)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
