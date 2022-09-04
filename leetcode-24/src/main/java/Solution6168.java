public class Solution6168 {
    private static final int MOD = 1000000007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(startPos - endPos);
        if ((k - diff) % 2 != 0 || diff > k) {
            return 0;
        }
        // 总 k 步
        // 向左 (k-diff)/2 向右 k - (k-diff)/2
        // C(k, (k-diff)/2)
        return (int) combination(k, (k - diff) / 2, MOD);
    }

    // C(n, m) = n! / m!(n-m)! （n 为下标） (% mod)
    private long combination(int n, int m, int mod) {
        // 线性求逆元
        long[] inv = new long[n + 1];
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        }
        // 递推求组合数，初值 C(k, 0) = 1
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n - i + 1) % mod * inv[i] % mod;
        }
        return res;
    }
}
/*
6168. 恰好移动 k 步到达某一位置的方法数目
https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/

第 309 场周赛 T2。

给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 109 + 7 取余 的结果。
如果所执行移动的顺序不完全相同，则认为两种方法不同。
注意：数轴包含负整数。
提示：
1 <= startPos, endPos, k <= 1000

组合数学
距离绝对值 diff = abs(startPos - endPos)
如果 k - diff 非偶数，无解
否则答案为 C(k, (k+d)/2)
注意除法不能直接取模，涉及到乘法逆元知识点 https://oi-wiki.org/math/number-theory/inverse/
相似题目: 1269. 停在原地的方案数
https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */