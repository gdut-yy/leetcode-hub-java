import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution497Tests {
    @Test
    public void example1() {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution497.Solution solution = new Solution497.Solution(rects);
        for (int i = 0; i < 5; i++) {
            int[] point = solution.pick();
            Assertions.assertTrue(inRects(rects, point), "pick 返回的点不在任何矩形内: " + point[0] + "," + point[1]);
        }
    }

    private boolean inRects(int[][] rects, int[] point) {
        for (int[] rect : rects) {
            if (point[0] >= rect[0] && point[0] <= rect[2]
                    && point[1] >= rect[1] && point[1] <= rect[3]) {
                return true;
            }
        }
        return false;
    }
}
