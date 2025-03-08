import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3446 {
    static class V1 {
        public int[][] sortMatrix(int[][] grid) {
            int n = grid.length;
            int[][] ans = new int[n][n];

            // i=j+0
            // ...
            // i=j+n-1
            for (int d = 0; d < n; d++) {
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int j = i - d;
                    if (j < 0) continue;
                    a.add(grid[i][j]);
                }
                a.sort(Comparator.reverseOrder());

                int p = 0;
                for (int i = 0; i < n; i++) {
                    int j = i - d;
                    if (j < 0) continue;
                    ans[i][j] = a.get(p++);
                }
            }

            // 右上角三角形
            for (int d = 1; d < n; d++) {
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int j = i + d;
                    if (j >= n) continue;
                    a.add(grid[i][j]);
                }
                a.sort(null);

                int p = 0;
                for (int i = 0; i < n; i++) {
                    int j = i + d;
                    if (j >= n) continue;
                    ans[i][j] = a.get(p++);
                }
            }
            return ans;
        }
    }

    static class V2 {
        public int[][] sortMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // 令 k=i-j+n 那么右上角 k=1 左下角 k=m+n-1, j=i-k+n, i=k+j-n
            for (int k = 1; k < m + n; k++) {
                int min_j = Math.max(n - k, 0);
                int max_j = Math.min(m + m - 1 - k, n - 1);

                List<Integer> a = new ArrayList<>();
                for (int j = min_j; j <= max_j; j++) {
                    int i = k + j - n;
                    a.add(grid[i][j]);
                }
                if (min_j == 0) a.sort(Comparator.reverseOrder());
                else a.sort(null);

                int p = 0;
                for (int j = min_j; j <= max_j; j++) {
                    int i = k + j - n;
                    grid[i][j] = a.get(p++);
                }
            }
            return grid;
        }
    }
}
/*
3446. 按对角线进行矩阵排序
https://leetcode.cn/problems/sort-matrix-by-diagonals/description/

第 436 场周赛 T1。

给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
- 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
- 右上角三角形 的对角线按 非递减顺序 排序。
提示：
grid.length == grid[i].length == n
1 <= n <= 10
-10^5 <= grid[i][j] <= 10^5

找规律 / 遍历对角线
时间复杂度 O(n^2 logn)。
 */