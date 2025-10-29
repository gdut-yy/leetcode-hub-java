package p2106;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2106D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static final int INF = (int) 2e9;

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = scanner.nextInt();

        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (a[i] >= b[m - 1 - suf[i]]) {
                suf[i]++;
                if (suf[i] == m) {
                    out.println(0);
                    return;
                }
            }
        }

        int ans = INF;
        if (suf[0] == m - 1) {
            ans = b[0];
        }
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (v >= b[pre]) {
                pre++;
            }
            if (pre + suf[i + 1] >= m) {
                out.println(0);
                return;
            }
            if (pre + suf[i + 1] == m - 1) {
                ans = Math.min(ans, b[pre]);
            }
        }
        if (ans == INF) {
            ans = -1;
        }
        out.println(ans);
    }
}
/*
D. Flower Boy
https://codeforces.com/contest/2106/problem/D

灵茶の试炼 2025-07-15
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤n) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 m 的数组 b(1≤b[i]≤1e9)。
你可以往 a 中的任意位置插入一个整数 k，也可以不插入。
能否让 a 有一个长为 m 的子序列 c，满足 c[i] >= b[i]？（注：子序列不一定连续）
如果无法做到，输出 -1。
如果可以不插入整数，输出 0。
否则输出 k 的最小值。

rating 1500
前后缀分解。
像匹配字符串的子序列那样，贪心匹配，如果 a[i] >= b[j]，那么一定选。
枚举用 a 的前 i 个数贪心匹配 b 的前缀，后 n-i 个数（倒着）贪心匹配 b 的后缀。注意 i 可以是 0 或者 n。
如果匹配个数之和 >= m，输出 0。
如果匹配个数之和 = m-1，用 b 中剩余没有匹配的那个数更新答案的最小值。
代码 https://codeforces.com/contest/2106/submission/328521932
代码备份（Ubuntu Pastebin）
======

Input
7
9 5
3 5 2 3 3 5 8 1 2
4 6 2 4 6
6 3
1 2 6 8 2 1
5 4 3
5 3
4 3 5 4 3
7 4 5
6 3
8 4 2 1 2 5
6 1 4
5 5
1 2 3 4 5
5 4 3 2 1
6 3
1 2 3 4 5 6
9 8 7
5 5
7 7 6 7 7
7 7 7 7 7
Output
6
3
7
0
-1
-1
7
 */
