import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution46Tests {
    private final Solution46 solution46 = new Solution46();

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
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = new ArrayList<>(List.of(
                List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)
        ));
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0, 1};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(0, 1), List.of(1, 0)));
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums = {1};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1)));
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }
}
