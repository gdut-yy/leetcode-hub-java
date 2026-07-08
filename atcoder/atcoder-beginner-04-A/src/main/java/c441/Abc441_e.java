package c441;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc441_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();
        long ans = 0;
        int[] cnt = new int[n * 2 + 1];
        cnt[n] = 1;
        int sum = n;
        long f = 0;
        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            if (b == 'A') {
                f += cnt[sum];
                sum++;
            } else if (b == 'B') {
                sum--;
                f -= cnt[sum];
            }
            ans += f;
            cnt[sum]++;
        }
        out.println(ans);
    }
}
/*
E - A > B substring
https://atcoder.jp/contests/abc441/tasks/abc441_e

灵茶の试炼 2026-06-16
题目大意：
输入 n(1≤n≤5e5) 和长为 n 的字符串 s，只包含大写字母 ABC。
s 有 n*(n+1)/2 个非空子串，其中有多少个子串 t，满足 t 中的 'A' 的个数严格大于 t 中的 'B' 的个数？

rating
做法同 LC3739. 统计主要元素子数组数目 II，可以 O(n) 时间。
代码 https://atcoder.jp/contests/abc441/submissions/76595967
======

Input 1
10
ACBBCABCAB
Output 1
8

Input 2
4
CCBC
Output 2
0

Input 3
36
CABACBBBBBAABABACCBCABCCABAABABBCBAC
Output 3
136
 */
