package p2049;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2049D {
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

    static final long INF = (long) 1e18;

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long[] f = new long[m];
        for (int i = 1; i < m; i++) {
            f[i] = INF;
        }
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[j] = scanner.nextInt();
            }
            long[] nf = new long[m];
            Arrays.fill(nf, INF);
            for (int shift = 0; shift < m; shift++) {
                long s = INF;
                for (int x = 0; x < m; x++) {
                    s = Math.min(s, f[x]) + a[(x + shift) % m];
                    nf[x] = Math.min(nf[x], s + (long) shift * k);
                }
            }
            f = nf;
        }
        out.println(f[m - 1]);
    }
}
/*
D. Shift + Esc
https://codeforces.com/contest/2049/problem/D

灵茶の试炼 2026-04-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤5e4。
每组数据输入 n m(1≤n,m≤200) k(0≤k≤1e9) 和 n 行 m 列的网格图，元素范围 [0,1e9]。
计算从左上角移动到右下角的的最小路径和。
每一步只能往右或者往下，路径和等于路径上的格子值之和。
在移动之前，你可以执行如下操作任意多次，每次操作的代价为 k，加到路径和中。
- 选择一个 i，把第 i 行循环左移一位。

rating 1900
如果没有循环左移，本题是 LC64. 最小路径和。
如果有循环左移呢？本题数据范围小，我们可以枚举每一行循环左移 shift = 0,1,2,...,m-1 次。
定义 f[i][j] 表示从左上角 (0,0) 移动到 (i,j) 的最小代价。
定义 g[i][shift][j] 表示从左上角 (0,0) 移动到 (i,j) 的最小代价，其中 a[i] 循环左移了 shift 次（不含这 shift 次的循环左移代价）。
如果从上面移动过来，那么问题变成从左上角 (0,0) 移动到 (i-1,j) 的最小代价，得 g[i][shift][j] = f[i-1][j] + a[i][(j+shift)%m]。
如果从左边移动过来，那么问题变成从左上角 (0,0) 移动到 (i,j-1) 的最小代价，其中 a[i] 循环左移了 shift 次，得 g[i][shift][j] = g[i][shift][j-1] + a[i][(j+shift)%m]。
两种情况取最小值，得 g[i][shift][j] = min(f[i-1][j], g[i][shift][j-1]) + a[i][(j+shift)%m]。
然后用 g[i][shift][j] + shift * k 更新 f[i][j] 的最小值。
这里把循环左移的代价放在最后算入，从而简化 g 的计算过程。
代码 https://codeforces.com/contest/2049/submission/371963958
代码备份（上面打不开的同学看这个）
======

Input
5
3 3 100
3 4 9
5 2 4
0 101 101
3 4 1
10 0 0 10
0 0 10 0
10 10 0 10
1 1 3
4
3 2 3
1 2
3 6
5 4
10 10 14
58 49 25 12 89 69 8 49 71 23
45 27 65 59 36 100 73 23 5 84
82 91 54 92 53 15 43 46 11 65
61 69 71 87 67 72 51 42 55 80
1 64 8 54 61 70 47 100 84 50
86 93 43 51 47 35 56 20 33 61
100 59 5 68 15 55 69 8 8 60
33 61 20 79 69 51 23 24 56 28
67 76 3 69 58 79 75 10 65 63
6 64 73 79 17 62 55 53 61 58
Output
113
6
4
13
618
 */
