import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution78Tests {
    private final Solution78 solution78 = new Solution78();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(1), List.of(2),
                List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)));
        List<List<Integer>> actual = solution78.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(1), List.of(2),
                List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)));
        List<List<Integer>> actual = solution78.subsets2(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(0)));
        List<List<Integer>> actual = solution78.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums = {0};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(), List.of(0)));
        List<List<Integer>> actual = solution78.subsets2(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
