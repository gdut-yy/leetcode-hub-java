package p2107;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2107C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static long k;
    static char[] s;
    static long[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextLong();
            s = scanner.next().toCharArray();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

    static final long INF = (long) 1e18;

    private static void solve() {
        long[] pre = new long[n];
        long maxF = 0, f = 0;
        boolean has0 = false;
        for (int i = 0; i < n; i++) {
            char b = s[i];
            pre[i] = f;
            if (b == '0') {
                a[i] = -INF;
                f = 0;
                has0 = true;
            } else {
                f = Math.max(f + a[i], 0);
                maxF = Math.max(maxF, f);
            }
        }
        if (maxF > k || maxF < k && !has0) {
            out.println("No");
            return;
        }

        long suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '0') {
                a[i] = k - pre[i] - suf;
                break;
            }
            suf = Math.max(suf + a[i], 0);
        }
        out.println("Yes");
        for (long v : a) {
            out.print(v + " ");
        }
        out.println();
    }
}
/*
C. Maximum Subarray Sum
https://codeforces.com/contest/2107/problem/C

灵茶の试炼 2025-06-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) k(1≤k≤1e12)，长为 n 的 01 字符串 s，长为 n 的数组 a(-1e6≤a[i]≤1e6)。
如果 s[i]=0，表示你可以修改 a[i] 的值为 [-1e18,1e18] 中的任意整数。保证 s[i]=0 时 a[i]=0。
能否让 a 的最大子数组和恰好等于 k？
如果无解，输出 No。
否则输出 Yes 和修改后的 a。

rating 1500
如果 s 中没有 0，那么最大子数组和 maxF 必须恰好等于 k。
下面讨论 s 中有 0 的情况。
首先把所有能修改的 a[i] 都改成最小的数 -1e18。
如果在这种情况下，maxF 仍然大于 k，那么无解。
否则 maxF <= k，此时一定有解，构造方法如下：
考虑其中任意一个可以修改的 a[i]。（其余 a[i] 仍然为 -1e18）
设以 i-1 结尾的最大子数组和为 pre，以 i+1 开头的最大子数组和为 suf。
把 a[i] 改成 k-pre-suf，那么最大子数组和一定包含 a[i] 且和恰好等于 k。
代码 https://codeforces.com/problemset/submission/2107/325381881
代码备份（Ubuntu Pastebin）
======

Input
10
3 5
011
0 0 1
5 6
11011
4 -3 0 -2 1
4 4
0011
0 0 -4 -5
6 12
110111
1 2 0 5 -1 9
5 19
00000
0 0 0 0 0
5 19
11001
-8 6 0 0 -5
5 10
10101
10 0 10 0 10
1 1
1
0
3 5
111
3 -1 3
4 5
1011
-2 0 1 -5
Output
Yes
4 0 1
Yes
4 -3 5 -2 1
Yes
2 2 -4 -5
No
Yes
5 1 9 2 2
Yes
-8 6 6 7 -5
Yes
10 -20 10 -20 10
No
Yes
3 -1 3
Yes
-2 4 1 -5
 */
