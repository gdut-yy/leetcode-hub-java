public class Solution3966 {
    public long goodIntegers(long l, long r, int k) {
        return count(r, k) - count(l - 1, k);
    }

    private long count(long n, int k) {
        if (n < 0) return 0;
        char[] s = Long.toString(n).toCharArray();
        Long[][][] memo = new Long[s.length][2][11];
        return dfs(0, 1, 10, k, s, memo);
    }

    private long dfs(int pos, int tight, int last, int k, char[] s, Long[][][] memo) {
        if (pos == s.length) return 1;
        if (memo[pos][tight][last] != null) return memo[pos][tight][last];
        int limit = tight == 1 ? s[pos] - '0' : 9;
        long res = 0;
        for (int d = 0; d <= limit; d++) {
            if (last == 10) {
                int nxt = (d == 0) ? 10 : d;
                int ntight = (tight == 1 && d == limit) ? 1 : 0;
                res += dfs(pos + 1, ntight, nxt, k, s, memo);
            } else if (Math.abs(d - last) <= k) {
                int ntight = (tight == 1 && d == limit) ? 1 : 0;
                res += dfs(pos + 1, ntight, d, k, s, memo);
            }
        }
        return memo[pos][tight][last] = res;
    }
}
/*
3966. 统计范围内的好整数
https://leetcode.cn/problems/count-good-integers-in-a-range/description/

第 185 场双周赛 T4。

给你三个整数 l，r 和 k。
如果一个数字中每一对 相邻 数位之间的 绝对差 都 至多 为 k，则称该数字为 好数。
返回在范围 [l, r]（包含边界）内的 好 整数的数量。
值 x 和 y 之间的 绝对差 定义为 abs(x - y)。
提示：
10 <= l <= r <= 10^15
0 <= k <= 9

数位 DP。
时间复杂度：O(D^2 * logr)，其中 D=10。
 */