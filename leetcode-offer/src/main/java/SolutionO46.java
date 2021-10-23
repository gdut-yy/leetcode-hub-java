public class SolutionO46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        // 定义 dp[i] 为 s[0,i-1] 的解码方法数
        int[] dp = new int[len + 1];
        // 边界条件
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            // 使用了一个字符
            if (numStr.charAt(i - 1) - '0' >= 0 && numStr.charAt(i - 1) - '0' <= 9) {
                dp[i] = dp[i] + dp[i - 1];
            }
            // 使用了两个字符
            if (i > 1 && numStr.charAt(i - 2) != '0' && ((numStr.charAt(i - 2) - '0') * 10 + (numStr.charAt(i - 1) - '0') < 26)) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[len];
    }
}
/*
剑指 Offer 46. 把数字翻译成字符串
https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

相似题目: 91. 解码方法
https://leetcode-cn.com/problems/decode-ways/
注意差异:
第 91 题 A~Z 1~26
本题 A~Z 0~25
 */

