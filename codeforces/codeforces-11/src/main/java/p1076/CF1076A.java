package p1076;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1076A {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static String s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        s = scanner.next();
        solve();
        out.flush();
    }

    private static void solve() {
        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                out.println(s.substring(0, i) + s.substring(i + 1));
                return;
            }
        }
        out.println(s.substring(0, n - 1));
    }
}
/*
A. Minimizing the String
https://codeforces.com/contest/1076/problem/A

灵茶の试炼 2025-06-16
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的字符串 s，只包含小写英文字母。
删除 s 中的至多一个字母，得到 s'，最小化 s' 的字典序。
输出 s'。
进阶：至多删除 k 个字母呢？

rating 1200
改成删除 k 次的话，可以用单调栈解决，只能出栈 k 次。本题 k=1。
见 402. 移掉 K 位数字
代码 https://codeforces.com/contest/1076/submission/324348702
代码备份（Ubuntu Pastebin）
======

Input
3
aaa
Output
aa

Input
5
abcda
Output
abca
 */
