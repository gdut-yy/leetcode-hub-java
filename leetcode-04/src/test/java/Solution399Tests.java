import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution399Tests {
    private final Solution399 solution399 = new Solution399();

    @Test
    public void example1() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        double[] expected = {6.00000, 0.50000, -1.00000, 1.00000, -1.00000};
        Assertions.assertArrayEquals(expected, solution399.calcEquation(equations, values, queries));
    }

    @Test
    public void example2() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values = {1.5, 2.5, 5.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
        double[] expected = {3.75000, 0.40000, 5.00000, 0.20000};
        Assertions.assertArrayEquals(expected, solution399.calcEquation(equations, values, queries));
    }

    @Test
    public void example3() {
        List<List<String>> equations = List.of(List.of("a", "b"));
        double[] values = {0.5};
        List<List<String>> queries = List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
        double[] expected = {0.50000, 2.00000, -1.00000, -1.00000};
        Assertions.assertArrayEquals(expected, solution399.calcEquation(equations, values, queries));
    }
}
