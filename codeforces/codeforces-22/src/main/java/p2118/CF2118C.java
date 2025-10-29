package p2118;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2118C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] cnt = new long[60];
        long ans = 0;
        for (long v : a) {
            ans += Long.bitCount(v);
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] += (v >> i & 1) ^ 1;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            long c = cnt[i];
            if (k >> i <= c) {
                ans += k >> i;
                break;
            }
            ans += c;
            k -= c << i;
        }
        out.println(ans);
    }
}
/*
C. Make It Beautiful
https://codeforces.com/contest/2118/problem/C

灵茶の试炼 2025-07-07
题目大意：
输入 T(≤5000) 表示 T 组数据。所有数据的 n 之和 ≤5000。
每组数据输入 n(1≤n≤5000) k(0≤k≤1e18) 和长为 n 的数组 a(0≤a[i]≤1e9)。
你可以执行至多 k 次如下操作：
把一个 a[i] 加一。
定义 popcount(x) 为 x 的二进制中的 1 的个数。
输出 popcount(a[i]) 之和的最大值。

rating 1300
贪心，对于偶数来说，只需一次操作就能把 1 的个数加一。
对于 ...01 这样的数来说，需要 2 次操作把 1 的个数加一。
对于 ...011 这样的数来说，需要 4 次操作把 1 的个数加一。
依此类推，统计 a 中第 i 位 0 的个数，从小到大贪心。
代码 https://codeforces.com/contest/2118/submission/327305824
代码备份（Ubuntu Pastebin）
======

Input
5
5 2
0 1 7 2 4
5 3
0 1 7 2 4
1 1
3
3 0
2 0 3
1 100000000000
0
Output
8
9
2
3
36
 */
