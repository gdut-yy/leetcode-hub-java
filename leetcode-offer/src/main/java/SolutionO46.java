public class SolutionO46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        // 预处理
        int[] s = new int[len];
        for (int i = 0; i < len; i++) {
            s[i] = numStr.charAt(i) - '0';
        }

        // f[i] 表示 s[0, i-1] 的解码方法数
        int[] f = new int[len + 1];
        f[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            // 使用 1 个字符
            f[i] += f[i - 1];

            // 使用 2 个字符
            if (i - 2 >= 0 && s[i - 2] != 0 && s[i - 2] * 10 + s[i - 1] <= 25) {
                f[i] += f[i - 2];
            }
        }
        return f[len];
    }
}
/*
剑指 Offer 46. 把数字翻译成字符串
https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
提示：
0 <= num < 2^31

相似题目: 91. 解码方法
https://leetcode.cn/problems/decode-ways/
注意差异:
第 91 题 A~Z 1~26
本题 A~Z 0~25
 */

