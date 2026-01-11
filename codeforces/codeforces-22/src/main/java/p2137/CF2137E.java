package p2137;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2137E {
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
        int k = scanner.nextInt();
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            cnt[v]++;
        }

        int m = 0;
        while (cnt[m] == 1) m++;

        int mex = m;
        while (cnt[mex] > 0) mex++;

        long ans = 1;
        if (k == 1) {
            ans = (long) mex * n;
            for (int i = 0; i < mex; i++) {
                int c = cnt[i];
                if (c == 1) {
                    ans += i - mex;
                }
            }
        } else if (mex > m) {
            ans = m * (m - 1L) / 2 + (long) (m + k % 2) * (n - m);
        } else if (n - m == 1) {
            ans = n * (n - 1L) / 2;
        } else {
            ans = m * (m - 1L) / 2 + (long) (m + 1 - k % 2) * (n - m);
        }
        out.println(ans);
    }
}
/*
E. Mexification
https://codeforces.com/contest/2137/problem/E

灵茶の试炼 2025-09-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) k(1≤k≤1e9) 和长为 n 的数组 a(0≤a[i]≤n)。
每次操作：
1. 创建一个长为 n 的数组 b，其中 b[i] 等于 a 中除去 a[i] 后的 mex，即不在这 n-1 个数中的最小非负整数。
2. 更新 a 为 b。
输出操作 k 次后的 sum(a)。

rating 1500
先想想 k=1 的情况，理解题意。
操作一次后：
对于 > mex(a) 的数，都变成了 mex(a)。
对于 < mex(a) 的数，如果这个数出现不止一次，那么变成 mex(a)，否则不变（不动点）。
例如 0123347 -> 0125545。
设只出现一次的数的集合为 b。
对于 k>=2，有如下三种情况：
1. mex(b) = mex(a)，例如 01245 -> 01233 -> 01244 -> ... 无限循环，周期为 2。
2. mex(b) = mex(a) 且 len(b) = n-1 的特殊情况，例如 0124 -> 0123 -> 0123 -> ... 无限循环，周期为 1。
3. mex(b) < mex(a)，例如 0123347 -> 0125545 -> 0123333 -> 0124444 -> ... 无限循环，周期为 2。
算出 mex(b) 后可以用数学公式 O(1) 解决，见代码。
代码 https://codeforces.com/contest/2137/submission/341121624
代码备份（上面打不开的同学看这个）
======

Input
5
3 3
0 2 1
2 4
0 2
4 1
0 0 1 1
8 7
6 6 2 4 3 0 1 8
2 2
0 0
Output
3
1
8
25
0
 */
