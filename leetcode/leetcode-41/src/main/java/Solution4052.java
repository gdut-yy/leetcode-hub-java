public class Solution4052 {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int col = (j - rowShift[i] + n) % n;
                int row = (i - colShift[col] + n) % n;
                ans[row][col] = grid[i][j];
            }
        }
        return ans;
    }
}
/*
4052. 行列循环移位
https://leetcode.cn/problems/cyclically-shift-rows-and-columns/description/

第 519 场周赛 T1。

给你一个整数 n、一个大小为 n x n 的二维整数数组 grid，以及两个长度均为 n 的整数数组 rowShift 和 colShift，其中：
- rowShift[i] 表示将 grid 的第 i 行向左 循环移位 的位数。
- colShift[j] 表示将 grid 的第 j 列向上 循环移位 的位数。
首先按照 rowShift 对每一行进行循环移位，然后按照 colShift 对每一列进行循环移位。
返回完成所有移位操作后的网格。
将第 i 行向左 循环移位 k 位时，只移动该行。原本位于第 j 列的元素会移动到第 (j - k + n) % n 列，其余各行保持不变。
将第 j 列向上 循环移位 k 位时，只移动该列。原本位于第 i 行的元素会移动到第 (i - k + n) % n 行，其余各列保持不变。
提示：
1 <= n == grid.length == grid[i].length <= 10
1 <= grid[i][j] <= 100
rowShift.length == colShift.length == n
0 <= rowShift[i], colShift[i] < n

模拟。
时间复杂度 O(n^2)。
 */