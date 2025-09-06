import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP3359 {
    public long countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] row = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] <= k) {
                    if (j - 1 >= 0 && grid[i][j - 1] >= grid[i][j]) {
                        row[i][j] = row[i][j - 1] + 1;
                    } else {
                        row[i][j] = 1;
                    }
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < m; j++) {
            int total = 0;
            Deque<int[]> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int height = 1;
                while (!st.isEmpty() && st.peek()[0] > row[i][j]) {
                    int[] top = st.pop();
                    total -= top[1] * (top[0] - row[i][j]);
                    height += top[1];
                }
                total += row[i][j];
                ans += total;
                st.push(new int[]{row[i][j], height});
            }
        }
        return ans;
    }
}
/*
$3359. 查找最大元素不超过 K 的有序子矩阵
https://leetcode.cn/problems/find-sorted-submatrices-with-maximum-element-at-most-k/description/

给定一个大小为 m x n 的二维矩阵 grid。同时给定一个 非负整数 k。
返回满足下列条件的 grid 的子矩阵数量：
- 子矩阵中最大的元素 小于等于 k。
- 子矩阵的每一行都以 非递增 顺序排序。
矩阵的子矩阵 (x1, y1, x2, y2) 是通过选择所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的 grid[x][y] 元素组成的矩阵。
提示：
1 <= m == grid.length <= 10^3
1 <= n == grid[i].length <= 10^3
1 <= grid[i][j] <= 10^9
1 <= k <= 10^9

参考1504的官方题解统计全 1 子矩形的方法二，改一改row矩阵
https://leetcode.cn/problems/find-sorted-submatrices-with-maximum-element-at-most-k/solutions/2997274/dan-diao-zhan-jie-fa-by-fzldq-8067/
 */