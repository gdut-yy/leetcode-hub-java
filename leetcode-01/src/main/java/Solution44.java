public class Solution44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 类似 Solution10 dp[i][j] 表示字符串 s 的前 i 个字符和模式 p 的前 j 个字符是否能匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
/*
44. 通配符匹配
https://leetcode-cn.com/problems/wildcard-matching/

给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。

动态规划。
时间复杂度 O(mn)
空间复杂度 O(mn)
相似题目: 10. 正则表达式匹配
https://leetcode-cn.com/problems/regular-expression-matching/
 */