import java.util.Arrays;

public class Solution3791 {
    private static final int OFFSET = 150;
    private long[][][] dp;
    private String s;
    private int n;

    public long countBalanced(long low, long high) {
        return count(high) - count(low - 1);
    }

    private long count(long x) {
        if (x < 10) return 0;
        s = Long.toString(x);
        n = s.length();
        dp = new long[n][2 * OFFSET + 1][17];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2 * OFFSET; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(0, 0, true, 0);
    }

    private long dfs(int pos, int diff, boolean tight, int len) {
        if (pos == n) {
            return (len >= 2 && diff == 0) ? 1 : 0;
        }
        int diffIndex = diff + OFFSET;
        if (!tight && dp[pos][diffIndex][len] != -1) return dp[pos][diffIndex][len];
        int limit = tight ? s.charAt(pos) - '0' : 9;
        long res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            int newLen;
            int newDiff = diff;
            if (len == 0) {
                if (d == 0) {
                    newLen = 0;
                } else {
                    newLen = 1;
                    newDiff = diff + d;
                }
            } else {
                newLen = len + 1;
                if ((len + 1) % 2 == 1) {
                    newDiff = diff + d;
                } else {
                    newDiff = diff - d;
                }
            }
            res += dfs(pos + 1, newDiff, newTight, newLen);
        }
        if (!tight) dp[pos][diffIndex][len] = res;
        return res;
    }
}
/*
3791. 给定范围内平衡整数的数目
https://leetcode.cn/problems/number-of-balanced-integers-in-a-range/description/

第 482 场周赛 T4。

给你两个整数 low 和 high。
如果一个整数同时满足以下 两个 条件，则称其为 平衡 整数：
- 它 至少 包含两位数字。
- 偶数位置上的数字之和 等于 奇数位置上的数字之和（最左边的数字位置为 1）。
返回一个整数，表示区间 [low, high]（包含两端）内平衡整数的数量。
提示：
1 <= low <= high <= 10^15

数位 DP。
时间复杂度 O(n^2 D^2)。
 */