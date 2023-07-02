import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionI1619 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int[][] land;
    private int m, n;
    private boolean[][] vis;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        m = land.length;
        n = land[0].length;
        vis = new boolean[m][n];

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 && !vis[i][j]) {
                    int area = bfs(i, j);
                    resList.add(area);
                }
            }
        }
        resList.sort(null);
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        vis[x][y] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1];
            res++;
            for (int[] dir : DIRECTIONS8) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && land[nx][ny] == 0 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return res;
    }
}
/*
面试题 16.19. 水域大小
https://leetcode.cn/problems/pond-sizes-lcci/

你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
示例：
输入：
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
输出： [1,2,4]
提示：
0 < len(land) <= 1000
0 < len(land[i]) <= 1000

BFS + 排序
时间复杂度 O(nm)
 */