import java.util.Arrays;

public class Solution4016 {
    public int maxArea(int[][] mat) {
        return Math.max(calc(mat), calc(transpose(mat)));
    }

    private int calc(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 221. 最大正方形（空间优化写法）
        // 计算 mat 下半部分的最大正方形的边长
        int[] sufMax = new int[m];
        int[] f = new int[n + 1];
        int mx = 0;
        for (int i = m - 1; i > 0; i--) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                int x = mat[i][j];
                if (x == 1) {
                    int tmp = f[j + 1];
                    f[j + 1] = Math.min(Math.min(last, f[j + 1]), f[j]) + 1;
                    last = tmp;
                    mx = Math.max(mx, f[j + 1]);
                } else {
                    f[j + 1] = 0;
                    last = 0;
                }
            }
            sufMax[i] = mx;
        }

        int ans = 0;
        // 计算 mat 上半部分的最大正方形的边长
        int preMax = 0;
        Arrays.fill(f, 0);
        for (int i = 0; i < m - 1; i++) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                int x = mat[i][j];
                if (x == 1) {
                    int tmp = f[j + 1];
                    f[j + 1] = Math.min(Math.min(last, f[j + 1]), f[j]) + 1;
                    last = tmp;
                    preMax = Math.max(preMax, f[j + 1]);
                } else {
                    f[j + 1] = 0;
                    last = 0;
                }
            }
            if (sufMax[i + 1] <= ans) {
                break; // 最优性优化：继续循环不会让 ans 变大
            }
            ans = Math.max(ans, Math.min(preMax, sufMax[i + 1])); // 题目要求两个正方形的边长相等
        }

        return ans * ans;
    }

    // 转置矩阵 mat
    private int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = mat[j][i];
            }
        }
        return a;
    }
}
/*
4016. 两个不重叠子正方形的最大面积
https://leetcode.cn/problems/maximum-area-of-two-non-overlapping-square-submatrices/description/

第 514 场周赛 T3。

给你一个大小为 m × n 的二维整数矩阵 mat，其中：
- mat[r][c] == 1 表示位于行 r 和列 c 的单元格是可用的。
- mat[r][c] == 0 表示它不可用。
你的任务是找到满足以下条件的 两个子矩阵 ：
- 这两个子矩阵都必须是边长为 k 的正方形。
- 这两个子矩阵不能共享任何单元格。
- 每个子矩阵只能覆盖 mat[r][c] == 1 的单元格。
返回单个正方形的最大可能面积。如果无法选择两个这样的正方形，则返回 0。
一个 子矩阵 (x1, y1, x2, y2) 包括所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的单元格 mat[x][y] 。
提示：
mat.length == m
mat[i].length == n
1 <= m, n <= 500
mat[i][j] 是 0 或 1。

前后缀分解，转化成 221 题。
相似题目: 221. 最大正方形
https://leetcode.cn/problems/maximal-square/
 */