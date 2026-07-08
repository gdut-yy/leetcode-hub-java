package p2143;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2143D2 {
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

    static final int MOD = (int) (1e9 + 7);

    static class Fenwick {
        int[] a;
        int n;

        Fenwick(int n) {
            this.n = n;
            a = new int[n + 1];
        }

        void update(int i, int v) {
            for (; i <= n; i += i & -i) a[i] = (a[i] + v) % MOD;
        }

        int pre(int i) {
            int res = 0;
            for (; i > 0; i &= i - 1) res = (res + a[i]) % MOD;
            return res;
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        Fenwick[] row = new Fenwick[n + 1];
        Fenwick[] col = new Fenwick[n + 1];
        for (int i = 0; i <= n; i++) {
            row[i] = new Fenwick(n);
            col[i] = new Fenwick(n);
        }
        row[1].update(1, 1);
        col[1].update(1, 1);
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            for (int y = 1; y <= v; y++) {
                int val = col[y].pre(v);
                if (val > 0) {
                    row[v].update(y, val);
                    col[y].update(v, val);
                }
            }
            for (int x = v + 1; x <= n; x++) {
                int val = row[x].pre(v);
                if (val > 0) {
                    row[x].update(v, val);
                    col[v].update(x, val);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) ans = (ans + row[i].pre(n)) % MOD;
        out.println(ans);
    }
}
/*
D2. Inversion Graph Coloring (Hard Version)
https://codeforces.com/contest/2143/problem/D2

灵茶の试炼 2026-05-01
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤2e3。
每组数据输入 n(1≤n≤2e3) 和长为 n 的数组 a(1≤a[i]≤n)。
对于序列 b，我们称 b 为好序列，当且仅当存在一种对每个下标染为红色或蓝色的方式，使得每个满足 i<j 且 b[i]>b[j] 的下标对 (i,j)，i 和 j 的颜色一定不同。
输出 a 有多少个好子序列（可以为空），模 1e9+7。
空子序列也算好子序列。

rating 2200
在颜色不同的下标对连边，可以得到一个二分图。
二分图同一部的元素必须是递增的（否则可以连边），所以好子序列至多分成两个递增子序列。
定义 f[x][y] 表示第一个递增子序列以 x 结尾、第二个递增子序列以 y 结尾时，好子序列的数目。
为避免重复统计，规定 x >= y。
特别地，用 y=0 表示第二个递增子序列为空的情况。
情况一：
把 v=a[i] 添加到第一个子序列的后面，必须满足 x <= v 且 y <= v，从而满足递增的要求。
枚举 y=1,2,...,v，更新 f[v][y] += sum_{x <= v} f[x][y]。
情况二：
把 v=a[i] 添加到第二个子序列的后面，必须满足 y <= v < x，这里 v != x 从而避免和情况一一样（避免重复统计）。
枚举 x=v+1,v+2,...,n，更新 f[x][v] += sum_{y <= v} f[x][y]。
转移方程计算的都是动态变化的前缀和，所以用 2n 个树状数组分别维护每行每列的前缀和。
初始值 f[0][0] = 1，表示空子序列也算一种方案。也可以写成 f[1][1] = 1，从而方便使用 1-index 的树状数组。
答案为所有 f[x][y] 之和。
代码 https://codeforces.com/problemset/submission/2143/372900502
代码备份（上面打不开的同学看这个）
======

Input
4
4
4 2 3 1
7
7 6 1 2 3 3 2
5
1 1 1 1 1
11
7 2 1 9 7 3 4 1 3 5 3
Output
13
73
32
619
 */
