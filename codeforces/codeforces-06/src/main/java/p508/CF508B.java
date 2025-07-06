package p508;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF508B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static char[] s;

    public static void main(String[] args) {
        s = scanner.next().toCharArray();
        solve();
        out.flush();
    }

    private static void solve() {
        int n = s.length;
        int last = -1;
        for (int i = 0; i < n; i++) {
            char b = s[i];
            if (b % 2 > 0) {
                continue;
            }
            last = i;
            if (b < s[n - 1]) {
                break;
            }
        }
        if (last < 0) {
            out.println(-1);
            return;
        }
        // s[last], s[n-1] = s[n-1], s[last]
        char s_last = s[last];
        s[last] = s[n - 1];
        s[n - 1] = s_last;

        out.println(new String(s));
    }
}
/*
B. Anton and currency you all know
https://codeforces.com/contest/508/problem/B

灵茶の试炼 2025-06-09
题目大意：
输入长度 ≤1e5 的十进制字符串 s，保证其为奇数，且无前导零。
交换 s 中的两个字符，使得结果是偶数，且字典序最大。
输出交换后的结果。
如果无法做到，输出 -1。

rating 1300
贪心：
如果有小于 s[n-1] 的偶数，交换可以让 s 变大，找最左边的偶数交换。
否则交换只能让 s 变小，那就找最右边的偶数交换。
如果没有偶数，返回 -1。
代码 https://codeforces.com/contest/508/submission/321862111
代码备份（洛谷）
======

Input
527
Output
572

Input
4573
Output
3574

Input
1357997531
Output
-1
 */
