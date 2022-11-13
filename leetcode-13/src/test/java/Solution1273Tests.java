import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1273Tests {
    private final Solution1273 solution1273 = new Solution1273();

    @Test
    public void example1() {
        int nodes = 7;
        int[] parent = {-1, 0, 0, 1, 2, 2, 2};
        int[] value = {1, -2, 4, 0, -2, -1, -1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1273.deleteTreeNodes(nodes, parent, value));
    }

    @Test
    public void example2() {
        int nodes = 7;
        int[] parent = {-1, 0, 0, 1, 2, 2, 2};
        int[] value = {1, -2, 4, 0, -2, -1, -2};
        int expected = 6;
        Assertions.assertEquals(expected, solution1273.deleteTreeNodes(nodes, parent, value));
    }

    @Test
    public void example3() {
        int nodes = 5;
        int[] parent = {-1, 0, 1, 0, 0};
        int[] value = {-672, 441, 18, 728, 378};
        int expected = 5;
        Assertions.assertEquals(expected, solution1273.deleteTreeNodes(nodes, parent, value));
    }

    @Test
    public void example4() {
        int nodes = 5;
        int[] parent = {-1, 0, 0, 1, 1};
        int[] value = {-686, -842, 616, -739, -746};
        int expected = 5;
        Assertions.assertEquals(expected, solution1273.deleteTreeNodes(nodes, parent, value));
    }
}
