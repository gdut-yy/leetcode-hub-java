import java.util.Arrays;

public class SolutionLCP25 {
    // https://leetcode.cn/problems/Uh984O/solution/liang-chong-ben-zhi-by-ofshare-9u1n/
    private static final int MOD = (int) (1e9 + 7);
    // 分组背包, 每种字母为一个组
    // dp[i][j]表示填满前i个位置[1...i], 使用前j种字母[1...j]的方案数
    private long[][] memo;
    private long[][] c;

    public int keyboard(int k, int n) {
        memo = new long[26 * 5 + 1][26 + 1];
        c = new long[26 * 5 + 1][5 + 1];
        for (int i = 0; i < 26 * 5 + 1; i++) {
            Arrays.fill(memo[i], -1);
            Arrays.fill(c[i], -1);
        }
        return (int) (dfs(n, 26, k) % MOD);
    }

    private long C(int x, int y) {
        if (x < y) {
            return 0;
        }
        if (x == y || y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        if (c[x][y] != -1) {
            return c[x][y];
        }

        // 选第 x 个位置 + 不选第 x 个位置
        long res = (C(x - 1, y - 1) + C(x - 1, y)) % MOD;
        c[x][y] = res;
        return res;
    }

    private long dfs(int i, int j, int k) {
        if (i <= 0) {
            return 1;
        }
        if (j <= 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long res = 0;
        // 枚举第 j 种字母选几个
        for (int x = 0; x <= k; ++x) {
            res = ((res + C(i, x) * dfs(i - x, j - 1, k)) % MOD);
        }
        memo[i][j] = res;
        return res;
    }
}
/*
LCP 25. 古董键盘
https://leetcode.cn/problems/Uh984O/

小扣在秋日市集购买了一个古董键盘。由于古董键盘年久失修，键盘上只有 26 个字母 a~z 可以按下，且每个字母最多仅能被按 k 次。
小扣随机按了 n 次按键，请返回小扣总共有可能按出多少种内容。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
提示：
1 <= k <= 5
1 <= n <= 26*k
 */