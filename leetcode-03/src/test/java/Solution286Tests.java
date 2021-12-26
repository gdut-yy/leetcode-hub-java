import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution286Tests {
    private final Solution286 solution286 = new Solution286();

    @Test
    public void example1() {
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        int[][] expected = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example2() {
        int[][] rooms = {{-1}};
        int[][] expected = {{-1}};
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example3() {
        int[][] rooms = {{2147483647}};
        int[][] expected = {{2147483647}};
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example4() {
        int[][] rooms = {{0}};
        int[][] expected = {{0}};
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }
}
