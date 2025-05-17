public class Solution3537 {
    private int[][] ans;
    private int val;

    public int[][] specialGrid(int n) {
        ans = new int[1 << n][1 << n];
        val = 0;
        dfs(0, 1 << n, 0, 1 << n);
        return ans;
    }

    private void dfs(int u, int d, int l, int r) {
        if (d - u == 1) {
            ans[u][l] = val++;
            return;
        }
        int m = (d - u) / 2;
        dfs(u, u + m, l + m, r);
        dfs(u + m, d, l + m, r);
        dfs(u + m, d, l, l + m);
        dfs(u, u + m, l, l + m);
    }
}
/*
3537. 填充特殊网格
https://leetcode.cn/problems/fill-a-special-grid/description/

第 448 场周赛 T2。

给你一个非负整数 N，表示一个 2^N x 2^N 的网格。你需要用从 0 到 2^2N - 1 的整数填充网格，使其成为一个 特殊 网格。一个网格当且仅当满足以下 所有 条件时，才能称之为 特殊 网格：
- 右上角象限中的所有数字都小于右下角象限中的所有数字。
- 右下角象限中的所有数字都小于左下角象限中的所有数字。
- 左下角象限中的所有数字都小于左上角象限中的所有数字。
- 每个象限也都是一个特殊网格。
返回一个 2^N x 2^N 的特殊网格。
注意：任何 1x1 的网格都是特殊网格。
提示：
0 <= N <= 10

递归。
 */