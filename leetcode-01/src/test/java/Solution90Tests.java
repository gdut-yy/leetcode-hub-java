import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution90Tests {
    private final Solution90 solution90 = new Solution90();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2)));
        List<List<Integer>> actual = solution90.subsetsWithDup(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2)));
        List<List<Integer>> actual = solution90.subsetsWithDup2(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(0)));
        List<List<Integer>> actual = solution90.subsetsWithDup(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums = {0};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(0)));
        List<List<Integer>> actual = solution90.subsetsWithDup2(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
