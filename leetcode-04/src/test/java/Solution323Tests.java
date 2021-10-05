import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution323Tests {
    private final Solution323 solution323 = new Solution323();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int expected = 2;
        Assertions.assertEquals(expected, solution323.countComponents(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int expected = 1;
        Assertions.assertEquals(expected, solution323.countComponents(n, edges));
    }
}
