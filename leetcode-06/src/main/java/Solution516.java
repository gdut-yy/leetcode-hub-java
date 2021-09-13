public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
/*
516. 最长回文子序列
https://leetcode-cn.com/problems/longest-palindromic-subsequence/

模板题。
关联 第 5 题 最长回文子串
https://leetcode-cn.com/problems/longest-palindromic-substring/

动态规划。 dp[i][j] 表示字符串 s 的下标范围 [i,j] 内的最长回文子序列的长度。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */