package p1613;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1613D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] f = new long[n + 1];
        long[] g2 = new long[n + 3];
        long[] l2 = new long[n + 1];
        long f1 = 0;
        for (int v : a) {
            if (v == 0) {
                f[0] = (f[0] * 2 + 1) % MOD;
            } else {
                if (v == 1) {
                    f1 = (f1 * 2 + 1) % MOD;
                } else {
                    g2[v] = (g2[v] * 2 + l2[v - 2] + f[v - 2]) % MOD;
                }
                f[v] = (f[v] * 2 + f[v - 1]) % MOD;
            }
            l2[v] = (l2[v] * 2 + g2[v + 2]) % MOD;
        }

        long ans = f1;
        ans += Arrays.stream(f).sum();
        ans += Arrays.stream(g2).sum();
        ans += Arrays.stream(l2).sum();
        ans %= MOD;
        return String.valueOf(ans);
    }
}
/*
D. MEX Sequences
https://codeforces.com/contest/1613/problem/D

灵茶の试炼 2023-07-20
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(1≤n≤5e5) 和长为 n 的数组 a(0≤a[i]≤n)。
称序列 b 为 MEX 序列，如果对所有 i 都有 abs(b[i] - mex(b[0],...,b[i])) ≤ 1 成立，其中 mex(S) 表示不在 S 中的最小非负整数。
输出 a 的非空 MEX 子序列的个数，模 998244353。
两个子序列只要有元素下标不同，就算不同的子序列。例如 a=[0,0,0] 有 7 个不同的非空子序列。
注：子序列不要求连续。

rating 1900
https://codeforces.com/problemset/submission/1613/214488015
提示 1：MEX 序列的第一个数可以是哪些？第二个数呢？第三个数呢？
提示 2：把状态机画出来，照着写一个状态机 DP。
提示 3：
定义 f[i] 表示形如 00...011...122...2 ... ii...i 的非空子序列个数。
例如 f[3] 包含 0111233。
那么有 f[0] = f[0] * 2 + 1，表示要么不选这个 0，要么和前面的 0 拼起来，要么单独成一个 0。
同理有 f[i] = f[i] * 2 + f[i-1]。
定义 g2[i]，表示形如 00...011...122...2 ... (i-2)... i... (i-2)... i... (i-2)... i... 的非空子序列个数。
例如 g2[3] 包含 000113313113。
定义 l2[i]，表示形如 00...011...122...2 ... (i+2)... i... (i+2)... i... (i+2)... i... 的非空子序列个数。
例如 l2[1] 包含 000113313331。
那么有
g2[i] = g2[i] * 2 + l2[i-2] + f[i-2]，
l2[i] = l2[i] * 2 + g2[i+2]。
最后还有一种情况，就是 11..1 这样的也算 MEX 序列。
定义 f1 表示它的个数，那么有
f1 = f1 * 2 + 1。
最后答案为 f1 + sum(f) + sum(g2) + sum(l2)。
======

input
4
3
0 2 1
2
1 0
5
0 0 0 0 0
4
0 1 2 3
output
4
2
31
7
 */
