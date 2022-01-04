import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution913Tests {
    private final Solution913 solution913 = new Solution913();

    @Test
    public void example1() {
        int[][] graph = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        int expected = 0;
        Assertions.assertEquals(expected, solution913.catMouseGame(graph));
    }

    @Test
    public void example2() {
        int[][] graph = {{1, 3}, {0}, {3}, {0, 2}};
        int expected = 1;
        Assertions.assertEquals(expected, solution913.catMouseGame(graph));
    }
}
