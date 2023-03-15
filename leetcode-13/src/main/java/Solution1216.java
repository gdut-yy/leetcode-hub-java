public class Solution1216 {
    public boolean isValidPalindrome(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();

        int[][] dp = new int[len][len];

        // 第一重循环控制长度
        for (int l = 2; l <= len; l++) {
            // 第二重循环控制左端点
            for (int left = 0; left < len; left++) {
                // 计算右端点
                int right = left - 1 + l;
                // 处理越界情况
                if (right >= len) {
                    continue;
                }
                // 考虑最坏情况：减小一位的字串是k回文，当前字串是k + 1回文
                dp[left][right] = Math.min(dp[left + 1][right], dp[left][right - 1]) + 1;
                // 如果两端相等，两端各减少一
                if (chars[left] == chars[right]) {
                    dp[left][right] = Math.min(dp[left][right], dp[left + 1][right - 1]);
                }
            }
        }
        // 判断是否 小于等于 k 即可
        return dp[0][len - 1] <= k;
    }
}
/*
$1216. 验证回文字符串 III
https://leetcode.cn/problems/valid-palindrome-iii/

给出一个字符串 s 和一个整数 k，若这个字符串是不是一个「k 回文 」，则返回 true 。
如果可以通过从字符串中删去最多 k 个字符将其转换为回文，那么这个字符串就是一个「k 回文 」。
提示：
1 <= s.length <= 1000
s 中只含有小写英文字母
1 <= k <= s.length

动态规划。
 */