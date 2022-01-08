import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1557Tests {
    private final Solution1557 solution1557 = new Solution1557();

    @Test
    public void example1() {
        int n = 6;
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2));
        List<Integer> expected = Arrays.asList(0, 3);
        List<Integer> actual = solution1557.findSmallestSetOfVertices(n, edges);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 5;
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4));
        List<Integer> expected = Arrays.asList(0, 2, 3);
        List<Integer> actual = solution1557.findSmallestSetOfVertices(n, edges);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }
}
