public class Solution1866 {
    private static final int MOD = (int) (1e9 + 7);
    private static long[][] TABLES;

    public int rearrangeSticks(int n, int k) {
        if (TABLES == null) {
            TABLES = new long[1001][1001];
            TABLES[0][0] = 1;
            for (int i = 1; i <= 1000; i++) {
                for (int j = 1; j <= i; j++) {
                    TABLES[i][j] = (TABLES[i - 1][j - 1] + (i - 1) * TABLES[i - 1][j]) % MOD;
                }
            }
        }
        return (int) TABLES[n][k];
    }
}
/*
1866. 恰有 K 根木棍可以看到的排列数目
https://leetcode.cn/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/

有 n 根长度互不相同的木棍，长度为从 1 到 n 的整数。请你将这些木棍排成一排，并满足从左侧 可以看到 恰好 k 根木棍。从左侧 可以看到 木棍的前提是这个木棍的 左侧 不存在比它 更长的 木棍。
- 例如，如果木棍排列为 [1,3,2,5,4] ，那么从左侧可以看到的就是长度分别为 1、3 、5 的木棍。
给你 n 和 k ，返回符合题目要求的排列 数目 。由于答案可能很大，请返回对 10^9 + 7 取余 的结果。
提示：
1 <= n <= 1000
1 <= k <= n

第一类斯特林数 https://oi-wiki.org/math/combinatorics/stirling/
灵神题解: https://leetcode.cn/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/solution/zhuan-huan-cheng-di-yi-lei-si-te-lin-shu-2y1k/
 */