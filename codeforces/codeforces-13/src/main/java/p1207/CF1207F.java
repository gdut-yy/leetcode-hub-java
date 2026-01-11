package p1207;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1207F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = 500001;

    private static void solve() {
        int[] a = new int[mx];
        int q = scanner.nextInt();

        int B = (int) Math.sqrt(mx / 5.0);
        int[][] sum = new int[B][];
        for (int i = 0; i < B; i++) {
            sum[i] = new int[i];
        }

        for (int j = 0; j < q; j++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (op == 1) {
                a[x] += y;
                for (int i = 1; i < B; i++) {
                    sum[i][x % i] += y;
                }
            } else if (x < B) {
                out.println(sum[x][y]);
            } else {
                int s = 0;
                for (int i = y; i < mx; i += x) {
                    s += a[i];
                }
                out.println(s);
            }
        }
    }
}
/*
F. Remainder Problem
https://codeforces.com/contest/1207/problem/F

灵茶の试炼 2025-08-20
题目大意：
一开始，你有一个长为 N=5e5 的数组 a，初始值全为 0。
输入 q(1≤n≤5e5) 和 q 个询问，格式如下：
"1 x y"：把 a[x] 增加 y。其中 1≤x≤N，-1e3≤y≤1e3。
"2 x y"：对于 [1,N] 中满足 i%x = y 的下标 i，输出这些 a[i] 的和。其中 0≤y<x≤N。

rating 2100
对于第二种询问：
如果 x 比较大，写个 O(N/B) 的暴力即可，其中 N 是数组大小，B 是阈值，满足 x >= B。
如果 x 比较小，即 x < B，我们可以维护下标模 x 余 y 的元素和：对于第一种询问，每次更新就需要花费 O(B) 的时间维护 sum[i][x%i] += y。
B 取 sqrt(N) 比较均衡。
然而，考虑到 CPU 计算取模比计算加法慢得多，实测 B 取 sqrt(N/6) ~ sqrt(N/4) 更快。
代码 https://codeforces.com/problemset/submission/1207/334458639
代码备份（上面打不开的同学看这个）
======

Input
5
1 3 4
2 3 0
2 4 3
1 4 -4
2 1 0
Output
4
4
0
 */
