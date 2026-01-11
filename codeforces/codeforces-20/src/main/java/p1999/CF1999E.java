package p1999;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1999E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = (int) (2e5 + 1);
    static long[] f = new long[mx];

    static {
        for (int i = 1; i < mx; i++) {
            f[i] = f[i / 3] + 1;
        }
        for (int i = 2; i < mx; i++) {
            f[i] += f[i - 1];
        }
    }

    private static void solve() {
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        long ans = f[r] + f[l] - f[l - 1] * 2;
        out.println(ans);
    }
}
/*
E. Triple Operations
https://codeforces.com/contest/1999/problem/E

灵茶の试炼 2025-10-06
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 L R(1≤L<R≤2e5)。
黑板上写有 L,L+1,...,R 一共 R-L+1 个整数。
每次操作，选择两个数字 x 和 y 擦掉，然后在黑板上写下 3x 和 floor(y/3)。
输出使黑板上的数字全为 0 的最小操作次数。可以证明，这总是可能的。

rating 1300
设把一个数 i 变成 0 的操作次数为 f[i]，那么有 f[i] = f[i/3] + 1。初始值 f[0]=0。
贪心，先把最小的 l 变成 0，操作 f[l] 次。另外一个数的操作次数增加 f[l]，加到答案中。
然后就可以直接把其他数变成 0 了，操作 f[l+1] + f[l+2] + ... + f[r] 次。
我们可以预处理 f[i]，然后算 f[i] 的前缀和。
代码 https://codeforces.com/contest/1999/submission/341930541
代码备份（上面打不开的同学看这个）
======

Input
4
1 3
2 4
199999 200000
19 84
Output
5
6
36
263
 */
