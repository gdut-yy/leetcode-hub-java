public class Solution1659 {
    private int m, n;
    private int[][][][][] dp;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        if (m > n) return getMaxGridHappiness(n, m, introvertsCount, extrovertsCount); // n <= m
        this.m = m;
        this.n = n;
        dp = new int[n][m][introvertsCount + 1][extrovertsCount + 1][(int) Math.pow(3, n)];
        return dfs(0, 0, introvertsCount, extrovertsCount, 0, 1);
    }

    private int dfs(int i, int j, int ix, int ex, int state, int bit) {
        if (i == n) return 0;
        if (j == m) return dfs(i + 1, 0, ix, ex, state, 1);
        if (dp[i][j][ix][ex][state] != 0) return dp[i][j][ix][ex][state];
        int ans = dfs(i, j + 1, ix, ex, set(state, bit, 0), bit * 3);
        int up = get(state, bit);
        int left = j == 0 ? -1 : get(state, bit / 3);
        int people = 0;
        people += up > 0 ? 1 : 0;
        people += left > 0 ? 1 : 0;
        int pre = 0;
        pre += up == 1 ? -30 : up == 2 ? 20 : 0;
        pre += left == 1 ? -30 : left == 2 ? 20 : 0;
        if (ix > 0) {
            ans = Math.max(ans, dfs(i, j + 1, ix - 1, ex, set(state, bit, 1), bit * 3) + 120 + pre - people * 30);
        }
        if (ex > 0) {
            ans = Math.max(ans, dfs(i, j + 1, ix, ex - 1, set(state, bit, 2), bit * 3) + 40 + pre + people * 20);
        }
        dp[i][j][ix][ex][state] = ans;
        return ans;
    }

    private int get(int state, int bit) {
        return state / bit % 3;
    }

    private int set(int state, int bit, int v) {
        return state - get(state, bit) * bit + v * bit;
    }
}
/*
1659. 最大化网格幸福感
https://leetcode.cn/problems/maximize-grid-happiness/description/

给你四个整数 m、n、introvertsCount 和 extrovertsCount 。有一个 m x n 网格，和两种类型的人：内向的人和外向的人。总共有 introvertsCount 个内向的人和 extrovertsCount 个外向的人。
请你决定网格中应当居住多少人，并为每个人分配一个网格单元。 注意，不必 让所有人都生活在网格中。
每个人的 幸福感 计算如下：
- 内向的人 开始 时有 120 个幸福感，但每存在一个邻居（内向的或外向的）他都会 失去  30 个幸福感。
- 外向的人 开始 时有 40 个幸福感，每存在一个邻居（内向的或外向的）他都会 得到  20 个幸福感。
邻居是指居住在一个人所在单元的上、下、左、右四个直接相邻的单元中的其他人。
网格幸福感 是每个人幸福感的 总和 。 返回 最大可能的网格幸福感 。
提示：
1 <= m, n <= 5
0 <= introvertsCount, extrovertsCount <= min(m * n, 6)

状态压缩动态规划
 */