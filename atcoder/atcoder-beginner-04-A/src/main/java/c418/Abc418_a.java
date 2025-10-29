package c418;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc418_a {
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
        String s = scanner.next();

        String ans = s.endsWith("tea") ? "Yes" : "No";
        out.println(ans);
    }
}
/*
A - I'm a teapot
https://atcoder.jp/contests/abc418/tasks/abc418_a

题目大意：
给你一个长度为 N 的字符串 S ，由小写英文字母组成。
请判断 S 是否是以 `tea` 结尾的字符串。

简单判断。
======

Input 1
8
greentea
Output 1
Yes

Input 2
6
coffee
Output 2
No

Input 3
3
tea
Output 3
Yes

Input 4
1
t
Output 4
No
 */
