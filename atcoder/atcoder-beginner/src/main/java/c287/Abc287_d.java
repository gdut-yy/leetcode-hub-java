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

前后缀分解
相似题目: 2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/
 */