public class Solution2002 {
    public int maxProduct(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder leftBuilder = new StringBuilder();
            StringBuilder rightBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    leftBuilder.append(s.charAt(j));
                } else {
                    rightBuilder.append(s.charAt(j));
                }
            }

            if (leftBuilder.length() == 0 || rightBuilder.length() == 0) {
                continue;
            }
            int leftMax = solution516longestPalindromeSubseq(leftBuilder.toString());
            int rightMax = solution516longestPalindromeSubseq(rightBuilder.toString());
            ans = Math.max(ans, leftMax * rightMax);
        }
        return ans;
    }

    private int solution516longestPalindromeSubseq(String s) {
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
2002. 两个回文子序列长度的最大乘积
https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

第 258 场周赛 T3。

给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相交 的。
请你返回两个回文子序列长度可以达到的 最大乘积 。
子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符串是一个 回文字符串 。
提示：
2 <= s.length <= 12
s 只含有小写英文字母。

马拉车并不适用（回文子串 和 回文子序列 还是有差距的）
回文子序列参考 第 516 题 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
n <= 12 直接暴力即可
或者 状态压缩 + dp
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
1960. 两个回文子字符串长度的最大乘积
https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-substrings/
 */