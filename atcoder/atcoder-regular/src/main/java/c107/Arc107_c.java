package c107;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Arc107_c {
    static int n, k;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;
    private static long ans;

    private static String solve() {
        ans = 1;
        f();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // a[i][j], a[j][i] = a[j][i], a[i][j]
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
        f();
        return String.valueOf(ans);
    }

    private static void f() {
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            int[] r = a[i];
            int fi = dsu.find(i);
            o:
            for (int i2 = 0; i2 < i; i2++) {
                int[] r2 = a[i2];
                int fi2 = dsu.find(i2);
                if (fi2 == fi) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    int v = r[j];
                    if (v + r2[j] > k) {
                        continue o;
                    }
                }
                dsu.fa[fi2] = fi;
                dsu.sz[fi] += dsu.sz[fi2];
                dsu.sz[fi2] = 0;
            }
        }
        for (int v : dsu.sz) {
            while (v > 1) {
                ans = ans * v % MOD;
                v--;
            }
        }
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            Arrays.fill(sz, 1);
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
C - Shuffle Permutation
https://atcoder.jp/contests/arc107/tasks/arc107_c

灵茶の试炼 2022-11-27
题目大意：
输入 n(≤50) 和 k(≤2n^2)。
然后输入 n^2 个数，表示一个 n*n 的矩阵 a，矩阵元素是 1~n^2 的一个排列。
每次操作，你可以选择下面的两个之一：
1. 选择两列 x 和 y，如果对于每个 i 都有 a[i][x]+a[i][y]≤k，则可以交换这两列。
2. 选择两行 x 和 y，如果对于每个 i 都有 a[x][i]+a[y][i]≤k，则可以交换这两行。
你可以执行任意多次操作。
输出你能得到的不同矩阵个数，模 998244353 的结果。

https://atcoder.jp/contests/arc107/submissions/36849409
首先，行与列的交换是不会影响到对方的。
那么就分别统计，最后用乘法原理相乘。
对于行，在可以交换的行 x 和 y 之间连边，建图。
那么对于一个大小为 sz 的连通分量，它可以产生 sz! 个不同的行。
把所有连通分量的大小的阶乘相乘，就得到了答案。
======

Input 1
3 13
3 2 7
4 8 9
1 6 5
Output 1
12

Input 2
10 165
82 94 21 65 28 22 61 80 81 79
93 35 59 85 96 1 78 72 43 5
12 15 97 49 69 53 18 73 6 58
60 14 23 19 44 99 64 17 29 67
24 39 56 92 88 7 48 75 36 91
74 16 26 10 40 63 45 76 86 3
9 66 42 84 38 51 25 2 33 41
87 54 57 62 47 31 68 11 83 8
46 27 55 70 52 98 20 77 89 34
32 71 30 50 90 4 37 95 13 100
Output 2
348179577
 */