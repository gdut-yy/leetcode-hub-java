package p335;

import java.util.Scanner;

public class CF335B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[26];
        for (char b : s) {
            cnt[b - 'a']++;
            if (cnt[b - 'a'] == 100) {
                return String.valueOf(b).repeat(100);
            }
        }

        int n = s.length;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }

        StringBuilder t = new StringBuilder();
        int i = 0, j = n - 1;
        while (i < j && t.length() < 50) {
            if (s[i] == s[j]) {
                t.append(s[i]);
                i++;
                j--;
            } else if (f[i][j] == f[i + 1][j]) {
                i++;
            } else {
                j--;
            }
        }
        // 不能直接 t.reverse().toString(), 会把 t 也翻转
        String rev = new StringBuilder(t).reverse().toString();
        if (i == j && t.length() < 50) {
            t.append(s[i]);
        }
        return t + rev;
    }
}
/*
B. Palindrome
https://codeforces.com/contest/335/problem/B

灵茶の试炼 2025-03-27
题目大意：
输入长度 ≤5e4 的字符串 s，只包含小写英文字母。
输出 s 的一个长度恰好为 100 的回文子序列。
如果不存在这样的子序列，输出 s 的最长回文子序列。
多解输出任意解。
注：子序列不一定连续。
变形：改成长度恰好为 101 呢？

rating 1900
看上去 s 很长，没法写 O(n^2) 的区间 DP。
但根据鸽巢原理，如果 s 长度超过 26 * 99，那么一定有一个字母出现了至少 100 次，直接把这个字母重复 100 次，作为答案。
这样 n 就 <= 26*99 了，可以写 O(n^2) 的区间 DP。
计算 s 的最长回文子序列的长度，然后输出具体方案（找到左半边，控制长度 <= 50）。如果最长回文子序列长度 < 100 则输出完整的最长回文子序列。
代码 https://codeforces.com/contest/335/submission/310886078
代码备份（洛谷）
变形题解答：没有区别，只要最长回文子序列长度 >= 101，答案是一定存在的。即使最长回文子序列长度是偶数，也可以通过去掉最里面的字母，变成奇数长度。
======

Input
bbbabcbbb
Output
bbbcbbb

Input
rquwmzexectvnbanemsmdufrg
Output
rumenanemur
 */
