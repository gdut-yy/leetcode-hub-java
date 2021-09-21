import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution77Tests {
    private final Solution77 solution77 = new Solution77();

    @Test
    public void example1() {
        int n = 4;
        int k = 2;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(2, 4), List.of(3, 4), List.of(2, 3),
                List.of(1, 2), List.of(1, 3), List.of(1, 4)));
        List<List<Integer>> actual = solution77.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 1;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(1)));
        List<List<Integer>> actual = solution77.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
