package p2162;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2162C {
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
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        int n = bitsLen(a);
        int m = bitsLen(b);
        if (m > n) {
            out.println(-1);
        } else if (m == n) {
            out.println(1 + " " + (a ^ b));
        } else {
            long hb = 1L << (n - 1);
            out.println(2 + " " + (a ^ b ^ hb) + " " + hb);
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Beautiful XOR
https://codeforces.com/contest/2162/problem/C

灵茶の试炼 2026-01-12
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 a b(1≤a,b≤1e9)。
你需要在 100 次操作内把 a 变成 b。
每次操作，选择一个在 [0, a] 中的整数 x，然后把 a 更新为 a XOR x。
如果无法做到，输出 -1。
否则输出操作次数（不需要最小化），以及每次操作的 x。

rating 1100
设 a 的长度为 n，b 的长度为 m。
分类讨论：
如果 m > n，必须异或一个长度大于 n 的数，无法做到。
如果 m = n，那么 a^b 二进制长度小于 n，所以 a^b < a 一定成立，可以操作。
如果 m < n，那么 a^b 可能大于 a，我们可以分两步走，先把 a 异或 a^b^hb，其中 hb 是 a 的最高位。然后再异或 hb。
代码 https://codeforces.com/contest/2162/submission/357078104
代码备份（上面打不开的同学看这个）
======

Input
6
9 6
13 13
292 929
405 400
998 244
244 353
Output
2
7 8
0
-1
1
5
2
25 779
-1
 */
