public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
1143. 最长公共子序列
https://leetcode-cn.com/problems/longest-common-subsequence/

LCS 裸题。动态规划。
dp[i][j] 表示 text1[0:i-1] 长度 i 与 text2[0:j-1] 长度 j 的最长公共子序列的长度

初始化
dp[0][j] = 0
dp[i][0] = 0

状态转移
若 text1[i-1] == text2[j-1] 则 dp[i][j] = dp[i-1][j-1] + 1
若 text1[i-1] != text2[j-1] 则 dp[i][j] = max(dp[i-1][j] + dp[i][j-1])

时间复杂度 O(mn)
空间复杂度 O(mn)
 */