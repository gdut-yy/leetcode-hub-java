public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // dp[i][j] 表示字符串 s 的下标范围 [i,j] 内的最长回文子序列的长度。
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
https://leetcode.cn/problems/longest-palindromic-subsequence/

给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
提示：
1 <= s.length <= 1000
s 仅由小写英文字母组成

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */