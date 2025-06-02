import java.util.Arrays;

public class Solution3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        int[] a = new int[k * k];
        for (int i = 0; i + k - 1 < m; i++) {
            for (int j = 0; j + k - 1 < n; j++) {
                int idx = 0;
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        a[idx++] = grid[i + x][j + y];
                    }
                }
                Arrays.sort(a);

                int mn = Integer.MAX_VALUE;
                for (int i0 = 1; i0 < k * k; i0++) {
                    if (a[i0] != a[i0 - 1]) { // 不同值
                        mn = Math.min(mn, a[i0] - a[i0 - 1]);
                    }
                }
                if (mn == Integer.MAX_VALUE) continue;
                ans[i][j] = mn;
            }
        }
        return ans;
    }
}
/*
3567. 子矩阵的最小绝对差
https://leetcode.cn/problems/minimum-absolute-difference-in-sliding-submatrix/description/

第 452 场周赛 T2。

给你一个 m x n 的整数矩阵 grid 和一个整数 k。
对于矩阵 grid 中的每个连续的 k x k 子矩阵，计算其中任意两个 不同值 之间的 最小绝对差 。
返回一个大小为 (m - k + 1) x (n - k + 1) 的二维数组 ans，其中 ans[i][j] 表示以 grid 中坐标 (i, j) 为左上角的子矩阵的最小绝对差。
注意：如果子矩阵中的所有元素都相同，则答案为 0。
子矩阵 (x1, y1, x2, y2) 是一个由选择矩阵中所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的单元格 matrix[x][y] 组成的矩阵。
提示：
1 <= m == grid.length <= 30
1 <= n == grid[i].length <= 30
-10^5 <= grid[i][j] <= 10^5
1 <= k <= min(m, n)

暴力枚举。
把 a 排序后，不同元素之差的最小值一定在相邻元素中，计算相邻不同元素之差的最小值。
时间复杂度 O((m-k)*(n-k) * k^2 logk)。
 */