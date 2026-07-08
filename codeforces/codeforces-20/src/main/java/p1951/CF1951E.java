package p1951;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1951E {
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

    static boolean isPal(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static void pr(String... a) {
        out.println("YES");
        out.println(a.length);
        out.println(String.join(" ", a));
    }

    private static void solve() {
        String s = scanner.next();
        if (!isPal(s)) {
            pr(s);
            return;
        }
        int n = s.length();
        int p = -1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(0)) {
                p = i;
                break;
            }
        }
        if (p < 0) {
            out.println("NO");
        } else if (!isPal(s.substring(p + 1))) {
            pr(s.substring(0, p + 1), s.substring(p + 1));
        } else if (p == 1 || p == n / 2) {
            out.println("NO");
        } else {
            pr(s.substring(0, p + 2), s.substring(p + 2));
        }
    }
}
/*
E. No Palindromes
https://codeforces.com/contest/1951/problem/E

灵茶の试炼 2026-03-05
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的字符串长度之和 ≤1e6。
每组数据输入长度 ≤1e6 的字符串 s，只包含小写英文字母。
把 s 划分成若干段，使得每一段都不是回文串。
如果无法做到，输出 NO。
否则输出 YES，划分段数 k，以及 k 个子串。
多解输出任意解。

rating 2000
如果 s 不是回文串，那么无需划分。
如果 s 是回文串，且所有字母都一样，那么无解。
否则，设 p 是第一个满足 s[p] != s[0] 的下标。
由于 s[p] != s[0]，所以子串 [0,p] 不是回文串。
如果子串 [p+1,n-1] 也不是回文串，那么这是一个解。
下面请你想一想，画一画，如果子串 [p+1,n-1] 是回文串，[0,n-1] 是回文串，那么 s 会是什么样的？
设 A = 子串 [0,p-1]，b = s[p]。
由于 s 回文串，所以 s = Ab...bA。
由于 [p+1,n-1] 是回文串，所以 s = AbAb...bA。
又由于 s 是回文串，所以 s = AbAb...bAbA。
依此类推。s 是一个 Ab 交替字符串。
分类讨论：
如果 p=1，即 s = ababab... 交替字符串，那么无解，因为 s 长为奇数，奇数 = 奇数 + 偶数，无论如何划分一定有奇数，它必定是回文串。
如果 p=n/2，即 s = aa...aabaa...aa，那么无论如何划分一定有一段只有一种字母，它必定是回文串。
否则，可以划分成 [0,p+1] 和 [p+2,n-1]。
第一段是 aaba 或者 aaaba 或者 aaaaba …… 这种，由于 p >= 2，所以一定不是回文串。
第二段开头是 p-1 个 a，结尾是 p 个 a，所以一定不是回文串。
代码 https://codeforces.com/contest/1951/submission/365358224
代码备份（上面打不开的同学看这个）
======

Input
3
sinktheyacht
lllllllll
uwuowouwu
Output
YES
1
sinktheyacht
NO
YES
3
uw uow ouwu
 */
