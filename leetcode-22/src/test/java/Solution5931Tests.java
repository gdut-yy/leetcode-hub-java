import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5931Tests {
    private final Solution5931 solution5931 = new Solution5931();

    @Test
    public void example1() {
        int[][] grid = {{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int stampHeight = 4;
        int stampWidth = 3;
        Assertions.assertTrue(solution5931.possibleToStamp(grid, stampHeight, stampWidth));
    }

    @Test
    public void example2() {
        int[][] grid = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int stampHeight = 2;
        int stampWidth = 2;
        Assertions.assertFalse(solution5931.possibleToStamp(grid, stampHeight, stampWidth));
    }
}
