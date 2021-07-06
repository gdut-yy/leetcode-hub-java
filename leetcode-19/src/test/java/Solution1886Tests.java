import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1886Tests {
    private final Solution1886 solution1886 = new Solution1886();

    @Test
    public void example1() {
        int[][] mat = {{0, 1}, {1, 0}}, target = {{1, 0}, {0, 1}};
        Assertions.assertTrue(solution1886.findRotation(mat, target));
    }

    @Test
    public void example2() {
        int[][] mat = {{0, 1}, {1, 1}}, target = {{1, 0}, {0, 1}};
        Assertions.assertFalse(solution1886.findRotation(mat, target));
    }

    @Test
    public void example3() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        Assertions.assertTrue(solution1886.findRotation(mat, target));
    }
}
