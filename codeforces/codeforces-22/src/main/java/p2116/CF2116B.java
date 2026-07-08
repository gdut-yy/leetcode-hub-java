package p2116;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2116B {
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

    static final int MOD = 998244353;
    static long[] pow2 = new long[100001];

    static {
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = scanner.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) q[i] = scanner.nextInt();
        int j = 0, k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (p[i] > p[j]) j = i;
            if (q[i] > q[k]) k = i;
            long v1 = Math.max(p[j], q[i - j]) * (1L << 32) + Math.min(p[j], q[i - j]);
            long v2 = Math.max(p[i - k], q[k]) * (1L << 32) + Math.min(p[i - k], q[k]);
            if (v1 > v2) {
                sb.append((pow2[p[j]] + pow2[q[i - j]]) % MOD).append(" ");
            } else {
                sb.append((pow2[p[i - k]] + pow2[q[k]]) % MOD).append(" ");
            }
        }
        out.println(sb);
    }
}
/*
B. Gellyfish and Baby's Breath
https://codeforces.com/contest/2116/problem/B

灵茶の试炼 2026-04-07
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5)，0~n-1 的排列 p 和 0~n-1 的排列 q。下标从 0 开始。
定义 r[i] 为 j=0,1,...,i 中的 pow(2, p[j]) + pow(2, q[i-j]) 的最大值。
输出 r[0],r[1],...,r[n-1]，模 998244353。

rating 1300
用二进制的观点看，以 max(p[j], q[i-j]) 为第一关键字，min(p[j], q[i-j]) 为第二关键字，组成一个 pair。这个 pair 越大，r[i] 越大。
所以只需要维护 p[j] 的最大值，以及 q[k] 的最大值。
对于每个 r[i]，比较 p[j] 和 q[k] 谁更优即可。
代码 https://codeforces.com/problemset/submission/2116/369866668
代码备份（上面打不开的同学看这个）
======

Input
3
3
0 2 1
1 2 0
5
0 1 2 3 4
4 3 2 1 0
10
5 8 9 3 4 0 2 7 1 6
9 5 1 4 0 3 2 8 7 6
Output
3 6 8
17 18 20 24 32
544 768 1024 544 528 528 516 640 516 768
 */
