public class Solution91 {
    public int numDecodings(String s) {
        int len = s.length();
        // 定义 dp[i] 为 s[0,i-1] 的解码方法数
        int[] dp = new int[len + 1];
        // 边界条件
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            // 使用了一个字符
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i] + dp[i - 1];
            }
            // 使用了两个字符
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[len];
    }
}
/*
91. 解码方法
https://leetcode-cn.com/problems/decode-ways/

要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

动态规划。
时间复杂度 O(n)
空间复杂度 O(n)
 */
