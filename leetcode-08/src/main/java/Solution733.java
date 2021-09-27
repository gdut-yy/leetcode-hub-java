import java.util.LinkedList;
import java.util.Queue;

public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int imageM = image.length;
        int imageN = image[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] dir : direction) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                if (nextM >= 0 && nextM < imageM && nextN >= 0 && nextN < imageN && image[nextM][nextN] == oldColor) {
                    image[nextM][nextN] = newColor;
                    queue.add(new int[]{nextM, nextN});
                }
            }
        }
        return image;
    }
}
/*
733. 图像渲染
https://leetcode-cn.com/problems/flood-fill/

广度优先搜索。
 */