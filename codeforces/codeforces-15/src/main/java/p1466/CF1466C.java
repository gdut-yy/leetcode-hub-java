package p1466;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1466C {
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
        char[] s = scanner.next().toCharArray();
        int ans = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i - 1] || (i > 1 && s[i] == s[i - 2])) {
                s[i] = 0;
                ans++;
            }
        }
        out.println(ans);
    }
}
/*
C. Canine poetry
https://codeforces.com/contest/1466/problem/C

灵茶の试炼 2026-04-21
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的字符串长度之和 ≤1e5。
每组数据输入长度 ≤1e5 的字符串 s，只包含小写英文字母。
修改 s 中的字母，使得 s 不含任何长度大于 1 的回文子串。
输出最少修改次数。

rating 1300
由于长度大于 3 的回文串，内部一定包含长度为 2 或 3 的回文子串，所以只要保证没有长度为 2 或 3 的回文子串。
这意味着不能出现 s[i] == s[i-1] 或者 s[i] == s[i-2] 的情况。
当出现这种情况时，改 s[i] 可以断开与更右边的字母的联系，相比改 s[i-1] 或者 s[i-2] 更好。
代码 https://codeforces.com/problemset/submission/1466/371441625
代码备份（上面打不开的同学看这个）
======

Input
7
babba
abaac
codeforces
zeroorez
abcdcba
bbbbbbb
a
Output
1
1
0
1
1
4
0
 */
