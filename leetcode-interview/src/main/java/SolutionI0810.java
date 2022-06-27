import java.util.LinkedList;
import java.util.Queue;

public class SolutionI0810 {
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
面试题 08.10. 颜色填充
https://leetcode.cn/problems/color-fill-lcci/

编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

同: 733. 图像渲染
https://leetcode.cn/problems/flood-fill/
 */