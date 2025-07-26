import java.util.Arrays;

public class Solution3621 {
    public long popcountDepth(long num, int k) {
        this.s = Long.toBinaryString(num).toCharArray();
        int n = s.length;
        if (k == 0) return 1;
        if (k == 1) return n - 1;

        memo = new long[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[Integer.bitCount(i)] + 1;
            if (f[i] == k) { // 注意
                ans += f(0, i, true);
            }
        }
        return ans;
    }

    private char[] s;
    private long[][] memo;

    private long f(int i, int left1, boolean isLimit) {
        if (i == s.length) {
            return left1 == 0 ? 1 : 0; // 注意
        }
        if (!isLimit && memo[i][left1] != -1) return memo[i][left1];
        long res = 0;
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = 0; d <= Math.min(up, left1); d++) {
            res += f(i + 1, left1 - d, isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][left1] = res;
        }
        return res;
    }
}
/*
3621. 位计数深度为 K 的整数数目 I
https://leetcode.cn/problems/number-of-integers-with-popcount-depth-equal-to-k-i/description/

第 161 场双周赛 T4。

给你两个整数 n 和 k。
对于任意正整数 x，定义以下序列：
- p0 = x
- pi+1 = popcount(pi)，对于所有 i >= 0，其中 popcount(y) 是 y 的二进制表示中 1 的数量。
这个序列最终会达到值 1。
x 的 popcount-depth （位计数深度）定义为使得 pd = 1 的 最小 整数 d >= 0。
例如，如果 x = 7（二进制表示 "111"）。那么，序列是：7 → 3 → 2 → 1，所以 7 的 popcount-depth 是 3。
你的任务是确定范围 [1, n] 中 popcount-depth 恰好 等于 k 的整数数量。
返回这些整数的数量。
提示:
1 <= n <= 10^15
0 <= k <= 5

数位 DP。同 CF914C。
时间复杂度：O(log^2(n))
相似题目: 3352. 统计小于 N 的 K 可约简整数
https://leetcode.cn/problems/count-k-reducible-numbers-less-than-n/description/
C. Travelling Salesman and Special Numbers
https://codeforces.com/contest/914/problem/C
rating 2341 (clist.by)
 */