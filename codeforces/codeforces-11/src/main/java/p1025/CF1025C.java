package p1025;

import java.util.Scanner;

public class CF1025C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;

        int ans = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n * 2 && s[i % n] != s[(i - 1) % n]; i++) {
            }
            ans = Math.max(ans, i - st);
        }
        ans = Math.min(ans, n);
        return String.valueOf(ans);
    }
}
/*
C. Plasticine zebra
https://codeforces.com/contest/1025/problem/C

灵茶の试炼 2022-07-04
题目大意：
给你一个字符串 s，仅包含 'b' 和 'w'，长度不超过 1e5。
每次操作你可以任意选择一个位置 k，把字符串分为长为 k 的前缀和长为 len(s)-k 的后缀，反转前缀和后缀，再重新拼起来，得到一个新字符串代替原来的 s。（用 Python 来说就是 s = s[:k][::-1] + s[k:][::-1]）
k 可以为 0，即翻转整个 s。
你可以操作任意多次。请输出你能得到的最长 bw 交替子串（形如 bwbwbw... 或 wbwbwb...）的长度。

rating 1600
https://codeforces.com/problemset/submission/1025/162703560
提示 1：把字符串首尾拼起来，形成一个环状的字符串。每次操作之后，字符串变成什么样了？（你可以在草稿纸上画出一个环形的 012345 下标序列，来模拟操作）
问题实际上求的是 s+s 的最长 bw 交替子串（但不超过 len(s)）。
======

input
bwwwbwwbw
output
5

input
bwwbwwb
output
3
 */
