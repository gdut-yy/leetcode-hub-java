public class Solution3933 {
    public int countLocalMaximums(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int wn = 32 - Integer.numberOfLeadingZeros(n);
        int wm = 32 - Integer.numberOfLeadingZeros(m);

        // st[k1][k2][i][j] 表示左上角在 (i, j)，右下角在 (i+(1<<k1)-1, j+(1<<k2)-1) 的子矩阵最大值
        int[][][][] st = new int[wn][wm][n][m];

        // 初始值
        st[0][0] = matrix;

        // 单独计算 k1 = 0
        for (int k2 = 1; k2 < wm; k2++) {
            int half = 1 << (k2 - 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= m - (1 << k2); j++) {
                    st[0][k2][i][j] = Math.max(st[0][k2 - 1][i][j], st[0][k2 - 1][i][j + half]);
                }
            }
        }

        for (int k1 = 1; k1 < wn; k1++) {
            int half = 1 << (k1 - 1);
            for (int k2 = 0; k2 < wm; k2++) {
                for (int i = 0; i <= n - (1 << k1); i++) {
                    for (int j = 0; j <= m - (1 << k2); j++) {
                        st[k1][k2][i][j] = Math.max(st[k1 - 1][k2][i][j], st[k1 - 1][k2][i + half][j]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = matrix[i][j];
                if (x == 0) {
                    continue;
                }
                int max1 = query(st, i - x, j - x + 1, i + x + 1, j + x, n, m);
                int max2 = query(st, i - x + 1, j - x, i + x, j + x + 1, n, m);
                if (Math.max(max1, max2) <= x) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 返回子矩阵最大值
    // 左闭右开，行号范围 [r1, r2)，列号范围 [c1, c2)
    private int query(int[][][][] st, int r1, int c1, int r2, int c2, int n, int m) {
        r1 = Math.max(r1, 0);
        c1 = Math.max(c1, 0);
        r2 = Math.min(r2, n);
        c2 = Math.min(c2, m);
        int k1 = 31 - Integer.numberOfLeadingZeros(r2 - r1);
        int k2 = 31 - Integer.numberOfLeadingZeros(c2 - c1);
        // 视作四个子矩阵的并集
        return Math.max(
                Math.max(st[k1][k2][r1][c1], st[k1][k2][r2 - (1 << k1)][c1]),
                Math.max(st[k1][k2][r1][c2 - (1 << k2)], st[k1][k2][r2 - (1 << k1)][c2 - (1 << k2)])
        );
    }
}
/*
3933. 矩阵中的局部最大值 II
https://leetcode.cn/problems/largest-local-values-in-a-matrix-ii/description/

第 502 场周赛 T3。

给你一个 n x m 的整数矩阵 matrix ，所有元素均为非负整数。
一个 非零 单元格 (row, col) 会按如下方式检查其附近的单元格：
- 令 x = matrix[row][col] 。
- 考虑在 (row, col) 的 x 行和 x 列范围内的每个单元格。
- 忽略矩阵外的单元格。
- 忽略行距离和列距离都恰好等于 x 的 单元格。
如果单元格 (row, col) 是 非零 的，并且所有考虑的单元格中没有一个值 大于 x ，那么该单元格就是一个 局部最大值 。
返回一个整数，表示 matrix 中 局部最大值 的数量。
提示：
1 <= n == matrix.length <= 200
1 <= m == matrix[i].length <= 200
0 <= matrix[i][j] <= 200

二维 ST 表 https://leetcode.cn/problems/largest-local-values-in-a-matrix-ii/solutions/3969719/mo-ban-er-wei-st-biao-pythonjavacgo-by-e-hw5t/
 */