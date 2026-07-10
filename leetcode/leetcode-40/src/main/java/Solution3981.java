public class Solution3981 {
    private static final int MOD = (int) (1e9 + 7);

    public int interleaveCharacters(String word1, String word2, String target) {
        int n = word1.length(), m = word2.length(), t = target.length();
        int total = countTotal(word1, word2, target, n, m, t);
        int only1 = countSubseq(word1, target, n, t);
        int only2 = countSubseq(word2, target, m, t);
        int ans = (total - only1) % MOD;
        ans = (ans - only2) % MOD;
        if (ans < 0) ans += MOD;
        return ans;
    }

    private int countTotal(String w1, String w2, String target, int n, int m, int t) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 1;
            }
        }
        int[][] nxt = new int[n + 1][m + 1];
        int[][] w1Sum = new int[n + 1][m + 1];
        int[][] w2Sum = new int[n + 1][m + 1];
        for (int k = t - 1; k >= 0; k--) {
            char c = target.charAt(k);
            for (int j = 0; j <= m; j++) {
                int sum = 0;
                for (int i = n - 1; i >= 0; i--) {
                    if (w1.charAt(i) == c) {
                        sum = (sum + dp[i + 1][j]) % MOD;
                    }
                    w1Sum[i][j] = sum;
                }
                w1Sum[n][j] = 0;
            }
            for (int i = 0; i <= n; i++) {
                int sum = 0;
                for (int j = m - 1; j >= 0; j--) {
                    if (w2.charAt(j) == c) {
                        sum = (sum + dp[i][j + 1]) % MOD;
                    }
                    w2Sum[i][j] = sum;
                }
                w2Sum[i][m] = 0;
            }
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    nxt[i][j] = (w1Sum[i][j] + w2Sum[i][j]) % MOD;
                }
            }
            int[][] tmp = dp;
            dp = nxt;
            nxt = tmp;
        }
        return dp[0][0];
    }

    private int countSubseq(String word, String target, int len, int t) {
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = 1;
        }
        int[] nxt = new int[len + 1];
        for (int k = t - 1; k >= 0; k--) {
            char c = target.charAt(k);
            int sum = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (word.charAt(i) == c) {
                    sum = (sum + dp[i + 1]) % MOD;
                }
                nxt[i] = sum;
            }
            nxt[len] = 0;
            int[] tmp = dp;
            dp = nxt;
            nxt = tmp;
        }
        return dp[0];
    }
}
/*
3981. 统计从两个字符串形成目标字符串的不同方案数
https://leetcode.cn/problems/count-distinct-ways-to-form-target-from-two-strings/description/

第 186 场双周赛 T4。

给你三个字符串 word1、word2 和 target。
你的任务是计算从 word1 和 word2 中选择字符以形成 target 的方案数，需满足以下条件：
- 对于 target 中的每个字符，从 word1 或 word2 中选择一个匹配的字符。
- 从 word1 中选择的下标必须是 严格 递增的。
- 从 word2 中选择的下标必须是 严格 递增的。
- 必须从 word1 和 word2 两者 中 至少 各选择一个字符。
如果对于 target 中的 至少 一个位置，选择的字符来自不同的字符串或不同的下标，则认为两种方案是不同的。
返回方案数。由于答案可能非常大，请返回它对 10^9 + 7 取余 后的结果。
提示：
1 <= word1.length, word2.length, target.length <= 100
word1、word2 和 target 仅由小写英文字母组成。

动态规划 + 容斥。
 */