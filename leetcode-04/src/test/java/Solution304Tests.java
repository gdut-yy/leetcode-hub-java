import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution304Tests {
    @Test
    public void example1() {
        // init
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Solution304.NumMatrix numMatrix = new Solution304.NumMatrix(matrix);
        // call
        int[][] calls = {{2, 1, 4, 3}, {1, 1, 2, 2}, {1, 2, 2, 4}};
        int[] expected = {8, 11, 12};
        for (int i = 0; i < calls.length; i++) {
            Assertions.assertEquals(expected[i], numMatrix.sumRegion(calls[i][0], calls[i][1], calls[i][2], calls[i][3]));
        }
    }
}
