import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1893Tests {
    private final Solution1893 solution1893 = new Solution1893();

    @Test
    public void example1() {
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;
        Assertions.assertTrue(solution1893.isCovered(ranges, left, right));
    }

    @Test
    public void example2() {
        int[][] ranges = {{1, 10}, {10, 20}};
        int left = 21, right = 21;
        Assertions.assertFalse(solution1893.isCovered(ranges, left, right));
    }
}
