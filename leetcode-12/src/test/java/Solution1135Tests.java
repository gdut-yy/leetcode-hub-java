import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1135Tests {
    private final Solution1135 solution1135 = new Solution1135();

    @Test
    public void example1() {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int expected = 6;
        Assertions.assertEquals(expected, solution1135.minimumCost(n, connections));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] connections = {{1, 2, 3}, {3, 4, 4}};
        int expected = -1;
        Assertions.assertEquals(expected, solution1135.minimumCost(n, connections));
    }
}
