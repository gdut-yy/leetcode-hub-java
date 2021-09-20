import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution39Tests {
    private final Solution39 solution39 = new Solution39();

    private final Comparator<List<Integer>> comparator = (o1, o2) -> {
        // o1.size() != o2.size();
        int minLen = Math.min(o1.size(), o2.size());
        for (int i = 0; i < minLen; i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return o1.size() - o2.size();
    };

    @Test
    public void example1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(7), List.of(2, 2, 3)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        int[] candidates = {1};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1, 1)));
        List<List<Integer>> actual = solution39.combinationSum(candidates, target);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }
}
