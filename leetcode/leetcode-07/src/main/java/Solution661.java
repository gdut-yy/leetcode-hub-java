public class Solution661 {
    private int[][] ps2d;

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        ps2d = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - 1), c1 = Math.max(0, j - 1);
                int r2 = Math.min(m - 1, i + 1), c2 = Math.min(n - 1, j + 1);
                int sum = sumRegion(r1, c1, r2, c2);
                int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }

    // 求 [r1,c1] 到 [r2,c2] 的累加和
    private int sumRegion(int r1, int c1, int r2, int c2) {
        return ps2d[r2 + 1][c2 + 1] - ps2d[r2 + 1][c1] - ps2d[r1][c2 + 1] + ps2d[r1][c1];
    }
}
/*
661. 图片平滑器
https://leetcode.cn/problems/image-smoother/

图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
提示:
m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255

二维前缀和。
时间复杂度 O(mn)。
 */