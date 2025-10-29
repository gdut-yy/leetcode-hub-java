package p2075;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2075D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static final int U = 58;
    static long[][] f = new long[U][U];
    static long[][] f2 = new long[U][U];
    static final long INF = (long) 8e18;

    static {
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], INF);
            Arrays.fill(f2[i], INF);
        }
        f[0][0] = 0;
        f2[0][0] = 0;
        for (int i = 1; i < U; i++) {
            for (int j = U - 1; j >= 0; j--) {
                for (int k = U - 1; k >= 0; k--) {
                    f[j][k] = min(f[j][k], f[j][Math.max(k - i, 0)] + (1L << i), f[Math.max(j - i, 0)][k] + (1L << i));
                    if (k >= i) {
                        f2[j][k] = Math.min(f2[j][k], f2[j][k - i] + (1L << i));
                    }
                    if (j >= i) {
                        f2[j][k] = Math.min(f2[j][k], f2[j - i][k] + (1L << i));
                    }
                }
            }
        }
    }

    static long min(long... values) {
        long mixValue = Long.MAX_VALUE;
        for (long i : values) {
            if (i < mixValue) {
                mixValue = i;
            }
        }
        return mixValue;
    }

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        if (x > y) {
            long temp = x;
            x = y;
            y = temp;
        }
        int n = bitsLen(x), m = bitsLen(y);
        long ans = f[n][m];
        for (int a = bitsLen(x ^ (y >> (m - n))); a < n; a++) {
            ans = min(ans, f2[a][a + m - n]);
        }
        out.println(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
D. Equalization
https://codeforces.com/contest/2075/problem/D

灵茶の试炼 2025-08-28
题目大意：
输入 T(≤1e5) 表示 T 组数据。
每组数据输入 x(0≤x≤1e17) 和 y(0≤y≤1e17)。
每次操作，选择一个正整数 k，把 x 变成 floor(x / pow(2,k))，或者把 y 变成 floor(y / pow(2,k))。这个操作的代价是 pow(2,k)。
所有操作中的 k 必须互不相同。
输出使 x 等于 y 的最小总代价。

rating 2000
x 除以 pow(2,k) 等价于 x 右移 k 次。
不妨设 x <= y。
设 x 的二进制长度为 n，y 的二进制长度为 m。
设 x 和 y 左对齐后，最长公共前缀的长度为 lcp。
有两种右移方案：
1. x 总共右移 a 次，其中 a 在 [n-lcp,n-1] 中。y 右移的次数等于 a+m-n。这样两个数右移后相同。
2. 或者，两个数都变成 0，那么 x 至少右移 n 次，y 至少右移 m 次。
由于题目要求 k 互不相同，问题变成：
1. 从 1 ~ 57 中选数字，【恰好】装满两个背包的最小代价。这两个背包的容量分别为 a 和 a+m-n，其中 a 在 [n-lcp,n-1] 中。
2. 从 1 ~ 57 中选数字，【至少】装满两个背包的最小代价。这两个背包的容量分别为 n 和 m。
注：pow(2,57) > 1e17。
代码 https://codeforces.com/contest/2075/submission/334007056
代码备份（上面打不开的同学看这个）
======

Input
5
0 1
6 2
3 3
13 37
4238659325782394 12983091057341925
Output
2
6
0
26
32764
 */
