public class SolutionLCR165 {
    public int crackNumber(int ciphertext) {
        String num = String.valueOf(ciphertext);
        int n = num.length();
        // 预处理
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = num.charAt(i) - '0';
        }

        // f[i] 表示 s[0, i-1] 的解码方法数
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            // 使用 1 个字符
            f[i] += f[i - 1];

            // 使用 2 个字符
            if (i - 2 >= 0 && s[i - 2] != 0 && s[i - 2] * 10 + s[i - 1] <= 25) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
/*
LCR 165. 解密数字
https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
- 密文由非负整数组成
- 数字 0-25 分别对应字母 a-z
请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
提示：
0 <= ciphertext < 2^31

注意差异:
第 91 题 A~Z 1~26
本题 A~Z 0~25
相似题目: 91. 解码方法
https://leetcode.cn/problems/decode-ways/
 */

