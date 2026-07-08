package p1694;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1694B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();
        long ans = n;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += i;
            }
        }
        out.println(ans);
    }
}
/*
B. Paranoid String
https://codeforces.com/contest/1694/problem/B

灵茶の试炼 2026-04-20
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的 01 字符串 s。
对于字符串 t，如果可以通过执行如下操作 |t|-1 次，把 t 的长度变成 1，那么称 t 为好字符串。
- 把 t 中的一个 01 变成 1，或者把 t 中的一个 10 变成 0。
输出 s 有多少个非空好子串。
注：长为 1 的子串一定是好子串。

rating 1200
操作相当于删除 1 左侧的 0，或者 0 左侧的 1。
或者说，如果 s[i-1] ≠ s[i]，那么可以删除 s[i-1]。
对于以 00 或 11 结尾的子串，由于无法消除末尾的 00 或 11，这样的子串不满足要求。
其他子串呢？
对于子串中的连续相同段，可以用这一段右侧的字符（例如 0001 中的 1）把 000 变成单个 0。
操作后，子串形如 101010... 可以从左到右消除，直到只剩下一个字符。
所以只有以 01 或者 10 结尾的子串才满足要求。
还有，长为 1 的子串一定满足要求。
代码 https://codeforces.com/problemset/submission/1694/371255839
代码备份（上面打不开的同学看这个）
======

Input
5
1
1
2
01
3
100
4
1001
5
11111
Output
1
3
4
8
5
 */
