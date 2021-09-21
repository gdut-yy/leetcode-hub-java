import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution373Tests {
    private final Solution373 solution373 = new Solution373();

    private final Comparator<List<Integer>> comparator = (o1, o2) -> {
        // o1.size() == o2.size();
        for (int i = 0; i < o1.size(); i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return 0;
    };

    @Test
    public void example1() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6)));
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6)));
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 1), List.of(1, 1)));
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 1), List.of(1, 1)));
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        int k = 3;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 3), List.of(2, 3)));
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3_2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        int k = 3;
        List<List<Integer>> expected = new java.util.ArrayList<>(List.of(List.of(1, 3), List.of(2, 3)));
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }
}
