import java.util.Arrays;

public class Solution1284 {
    // https://leetcode.cn/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/solutions/101359/zhuan-hua-wei-quan-ling-ju-zhen-de-zui-shao-fan-2/
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};

    private void convert(int[][] mat, int m, int n, int i, int j) {
        for (int k = 0; k < 5; ++k) {
            int i0 = i + dirs[k][0];
            int j0 = j + dirs[k][1];
            if (i0 >= 0 && i0 < m && j0 >= 0 && j0 < n) {
                mat[i0][j0] ^= 1;
            }
        }
    }

    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = Integer.MAX_VALUE;

        for (int bin = 0; bin < (1 << n); ++bin) {
            int[][] matCopy = new int[m][n];
            for (int i = 0; i < m; i++) {
                matCopy[i] = Arrays.copyOf(mat[i], n);
            }

            int flipCnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((bin & (1 << j)) != 0) {
                    flipCnt++;
                    convert(matCopy, m, n, 0, j);
                }
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matCopy[i - 1][j] == 1) {
                        flipCnt++;
                        convert(matCopy, m, n, i, j);
                    }
                }
            }

            boolean flag = true;
            for (int j = 0; j < n; ++j) {
                if (matCopy[m - 1][j] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans = Math.min(ans, flipCnt);
            }
        }

        return (ans != Integer.MAX_VALUE ? ans : -1);
    }
}
/*
1284. 转化为全零矩阵的最少反转次数
https://leetcode.cn/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/description/

给你一个 m x n 的二进制矩阵 mat。每一步，你可以选择一个单元格并将它反转（反转表示 0 变 1 ，1 变 0 ）。如果存在和它相邻的单元格，那么这些相邻的单元格也会被反转。相邻的两个单元格共享同一条边。
请你返回将矩阵 mat 转化为全零矩阵的最少反转次数，如果无法转化为全零矩阵，请返回 -1 。
二进制矩阵 的每一个格子要么是 0 要么是 1 。
全零矩阵 是所有格子都为 0 的矩阵。
示例 1：
输入：mat = [[0,0],[0,1]]
输出：3
解释：一个可能的解是反转 (1, 0)，然后 (0, 1) ，最后是 (1, 1) 。
示例 2：
输入：mat = [[0]]
输出：0
解释：给出的矩阵是全零矩阵，所以你不需要改变它。
示例 3：
输入：mat = [[1,0,0],[1,0,0]]
输出：-1
解释：该矩阵无法转变成全零矩阵
提示：
m == mat.length
n == mat[0].length
1 <= m <= 3
1 <= n <= 3
mat[i][j] 是 0 或 1 。
 */