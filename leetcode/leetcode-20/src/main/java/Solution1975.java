public class Solution1975 {
    public long maxMatrixSum(int[][] matrix) {
        int negCnt = 0, zeroCnt = 0;
        long ans = 0;
        int minAbs = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int v : row) {
                if (v < 0) negCnt++;
                else if (v == 0) zeroCnt++;
                int abs = Math.abs(v);
                ans += abs;
                minAbs = Math.min(minAbs, abs);
            }
        }
        if (negCnt % 2 == 0 || zeroCnt > 0) return ans; // 若负数数量为偶数，或者存在 0，则直接返回
        return ans - 2L * minAbs; // 给绝对值最小的数添加负号
    }
}
/*
1975. 最大方阵和
https://leetcode.cn/problems/maximum-matrix-sum/

第 59 场双周赛 T2。

给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
- 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
如果两个元素有 公共边 ，那么它们就是 相邻 的。
你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
提示：
n == matrix.length == matrix[i].length
2 <= n <= 250
-10^5 <= matrix[i][j] <= 10^5

这意味着我们可以改变偶数对负数的取值，同时存在两种边界场景：
case1: 符号对 0 没有影响，-0 == 0，因此可以将 0 与负数归为一类。
case2: 当负数的绝对值大于最小正数绝对值时，我们可以将其符号进行互换，达到最优解。若 |-4| > |1| 那么选择 +4-1
 */