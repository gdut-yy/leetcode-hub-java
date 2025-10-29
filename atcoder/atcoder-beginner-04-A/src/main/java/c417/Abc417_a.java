package c417;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc417_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String s = scanner.next();

        String ans = s.substring(a, n - b);
        out.println(ans);
    }
}
/*
A - A Substring
https://atcoder.jp/contests/abc417/tasks/abc417_a

题目大意：
给你一个由 N 个小写英文字母组成的字符串 S 。
输出从 S 中去掉第一个 A 字符和最后一个 B 字符后得到的 N-A-B 字符串。

substring 截取一下。
======

Input 1
7 1 3
atcoder
Output 1
tco

Input 2
1 0 0
a
Output 2
a

Input 3
20 4 8
abcdefghijklmnopqrst
Output 3
efghijkl
 */
