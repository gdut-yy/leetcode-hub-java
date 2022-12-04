public class Solution1312 {
    public int minInsertions(String s) {
        int n = s.length();

        // dp[i][j] 表示对于 s[i,j] 最少添加的字符数量，使得 s[i,j] 变为回文串
        int[][] dp = new int[n][n];
        // span = j-i+1
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i <= n - span; i++) {
                int j = i + span - 1;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
/*
1312. 让字符串成为回文串的最少插入次数
https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/

给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
请你返回让 s 成为回文串的 最少操作次数 。
「回文串」是正读和反读都相同的字符串。
提示：
1 <= s.length <= 500
s 中所有字符都是小写字母。

区间 DP
官方题解 https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/solution/rang-zi-fu-chuan-cheng-wei-hui-wen-chuan-de-zui--2/
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */