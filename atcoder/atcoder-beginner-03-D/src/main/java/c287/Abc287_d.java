package c287;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc287_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solve(s, t));
    }

    private static String solve(String s, String t) {
        int n = s.length();
        int m = t.length();

        // pre[i] 表示前缀长度为 i 时，前缀是否 match
        boolean[] pre = new boolean[m + 1];
        pre[0] = true;
        for (int i = 1; i <= m; i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = t.charAt(i - 1);
            pre[i] = pre[i - 1] && (ch1 == ch2 || ch1 == '?' || ch2 == '?');
            if (!pre[i]) break;
        }

        // suf[i] 表示后缀长度为 i 时，后缀是否 match
        boolean[] suf = new boolean[m + 1];
        suf[0] = true;
        for (int i = 1; i <= m; i++) {
            char ch1 = s.charAt(n - i);
            char ch2 = t.charAt(m - i);
            suf[i] = suf[i - 1] && (ch1 == ch2 || ch1 == '?' || ch2 == '?');
            if (!suf[i]) break;
        }

        String[] res = new String[m + 1];
        for (int i = 0; i < m + 1; i++) {
            res[i] = pre[i] && suf[m - i] ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), res);
    }
}
/*
D - Match or Not
https://atcoder.jp/contests/abc287/tasks/abc287_d

题目大意：
给出由小写英文字母和?组成的字符串 S 和 T。这里，|S|>|T| 成立(对于字符串 X，|X| 表示 X 的长度)。
两个满足 |X|=|Y| 的字符串 X 和 Y 当且仅当:
- 一个可以通过替换 X 等于 Y ?在 X 和 Y 中独立使用任何英文字母。
对每个 x=0,1，…，|T|，求解如下问题:
- 设 S '为长度为 |T| 的字符串，由 S 的前 x 个字符与后(|T|−x)个字符串联而得，且不改变顺序。如果 S '和 T 匹配，打印 Yes，否则打印 No。

前后缀分解
相似题目: 2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/
======

Input 1
a?c
b?
Output 1
Yes
No
No

Input 2
atcoder
?????
Output 2
Yes
Yes
Yes
Yes
Yes
Yes

Input 3
beginner
contest
Output 3
No
No
No
No
No
No
No
No
 */