import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution254Tests {
    private final Solution254 solution254 = new Solution254();

    @Test
    public void example1() {
        int n = 1;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution254.getFactors(n));
    }

    @Test
    public void example2() {
        int n = 37;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution254.getFactors(n));
    }

    @Test
    public void example3() {
        int n = 12;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(2, 6), List.of(2, 2, 3), List.of(3, 4)));
        List<List<Integer>> actual = solution254.getFactors(n);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        int n = 32;
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(2, 16), List.of(2, 2, 8), List.of(2, 2, 2, 4),
                List.of(2, 2, 2, 2, 2), List.of(2, 4, 4), List.of(4, 8)));
        List<List<Integer>> actual = solution254.getFactors(n);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
