package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DDBook21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.nextLine();
        System.out.println(solve(s));
    }

    public static String solve(String s) {
        // 长度 0 和 1
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 记录答案开始下标与最大长度
        int resLen = 1;
        int resBegin = 0;

        char[] chars = s.toCharArray();
        // 注意此处 left <= len
        for (int left = 2; left <= len; left++) {
            for (int i = 0; i < len; i++) {
                int j = left + i - 1;
                if (j >= len) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 转移方程
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 刷新最大值
                if (dp[i][j] && j - i + 1 > resLen) {
                    resLen = j - i + 1;
                    resBegin = i;
                }
            }
        }
        return s.substring(resBegin, resBegin + resLen);
    }
}
/*
找出最长字符串并输出
https://leetcode.cn/leetbook/read/didiglobal2/e7inig/

在公司内部的一次联谊晚会上，参会人员领到了主持人随机发放的字符卡片，且每个卡片只有一个字母(英文或者数字)，现在需要涉及一个 算法找出连续字符最多的一个字母或字符串，可获得抽奖机会
格式：
输入：
- 随机输入字符串(英文或者数字)
输出：
- 找出连续相同字符最多的字符并输出，如果相同数量的字符有多组，那么就从左往右输出第一组。
示例 1：
输入：abcdefkk11
输出：kk
示例 2：
输入：abcdef
输出：a
示例 3：
输入：aaabbcc
输出：aaa
示例 4：
输入：aabbcc
输出：aa

相似题目: 5. 最长回文子串
https://leetcode.cn/problems/longest-palindromic-substring/
 */