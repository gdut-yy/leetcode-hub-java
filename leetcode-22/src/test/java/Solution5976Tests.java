import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5976Tests {
    private final Solution5976 solution5976 = new Solution5976();

    @Test
    public void example1() {
        int[][] matrix = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        Assertions.assertTrue(solution5976.checkValid(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = {{1, 1, 1}, {1, 2, 3}, {1, 2, 3}};
        Assertions.assertFalse(solution5976.checkValid(matrix));
    }
}
