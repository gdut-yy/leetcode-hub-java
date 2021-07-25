import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution973Tests {
    private final Solution973 solution973 = new Solution973();

    @Test
    public void example1() {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] expected = {{-2, 2}};
        Assertions.assertArrayEquals(expected, solution973.kClosest(points, k));
    }

    @Test
    public void example2() {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] expected = {{3, 3}, {-2, 4}};
        Assertions.assertArrayEquals(expected, solution973.kClosest(points, k));
    }
}
