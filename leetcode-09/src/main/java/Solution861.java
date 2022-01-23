public class Solution861 {
    public int matrixScore(int[][] grid) {
        // step1 如果某行的第一位不是 1，进行翻转
        int M = grid.length;
        int N = grid[0].length;
        for (int i = 0; i < M; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }
        // step2 在每行第一位都是 1 的前提下，逐列比较，如果某列 0 的个数大于 1 的个数，进行翻转
        for (int j = 1; j < N; j++) {
            int cnt0 = 0;
            for (int i = 0; i < M; i++) {
                if (grid[i][j] == 0) {
                    cnt0++;
                }
            }
            if (cnt0 > M - cnt0) {
                flipCol(grid, j);
            }
        }
        // step3 二进制相加
        int res = 0;
        for (int i = 0; i < M; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < N; j++) {
                stringBuilder.append(grid[i][j]);
            }
            res += Integer.parseInt(stringBuilder.toString(), 2);
        }
        return res;
    }

    private void flipRow(int[][] grid, int row) {
        int N = grid[0].length;
        for (int j = 0; j < N; j++) {
            if (grid[row][j] == 0) {
                grid[row][j] = 1;
            } else {
                grid[row][j] = 0;
            }
        }
    }

    private void flipCol(int[][] grid, int col) {
        int M = grid.length;
        for (int i = 0; i < M; i++) {
            if (grid[i][col] == 0) {
                grid[i][col] = 1;
            } else {
                grid[i][col] = 0;
            }
        }
    }
}
/*
861. 翻转矩阵后的得分
https://leetcode-cn.com/problems/score-after-flipping-matrix/

第 91 场周赛 T3。

有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。

贪心，
最高位的 1 权重最高，如 1000=8 > 0111=7，需要确保最高位都为 1，
其次，其余位 1 的个数要尽可能多。
 */