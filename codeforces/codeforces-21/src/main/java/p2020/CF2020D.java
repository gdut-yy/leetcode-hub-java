package p2020;

import java.util.Scanner;

public class CF2020D {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    static class V1 {
        static int[][] global_fa;

        private static String solve() {
            global_fa = new int[11][];
            for (int i = 0; i < global_fa.length; i++) {
                global_fa[i] = new int[n + i + 1];
                for (int j = 0; j < global_fa[i].length; j++) {
                    global_fa[i][j] = j;
                }
            }

            for (int qi = 0; qi < m; qi++) {
                int a = scanner.nextInt();
                int d = scanner.nextInt();
                int k = scanner.nextInt();

                int to = find(d, a + k * d);
                for (int i = find(d, a); i <= a + k * d; i = find(d, i + d)) {
                    global_fa[d][find(d, i)] = to;
                }
            }

            int cc = n;
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j <= n; j++) {
                    int x = find(0, j);
                    int y = find(0, find(i, j));
                    if (x != y) {
                        global_fa[0][x] = y;
                        cc--;
                    }
                }
            }
            return String.valueOf(cc);
        }

        static int find(int d, int x) {
            int[] fa = global_fa[d];
            int rt = x;
            while (fa[rt] != rt) {
                rt = fa[rt];
            }
            while (fa[x] != rt) {
//            fa[x], x = rt, fa[x]
                int fax = fa[x];
                fa[x] = rt;
                x = fax;
            }
            return rt;
        }
    }

    static DSU[] dsus;

    private static String solve() {
        dsus = new DSU[11];
        for (int i = 0; i < 11; i++) {
            dsus[i] = new DSU(n + i + 1);
        }

        for (int qi = 0; qi < m; qi++) {
            int a = scanner.nextInt();
            int d = scanner.nextInt();
            int k = scanner.nextInt();

            int to = find(d, a + k * d);
            for (int i = find(d, a); i <= a + k * d; i = find(d, i + d)) {
                union(d, find(d, i), to);
            }
        }

        int cc = n;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j <= n; j++) {
                int x = find(0, j);
                int y = find(0, find(i, j));
                if (x != y) {
                    union(0, x, y);
                    cc--;
                }
            }
        }
        return String.valueOf(cc);
    }

    static int find(int d, int x) {
        DSU dsu = dsus[d];
        return dsu.find(x);
    }

    static void union(int d, int p, int q) {
        DSU dsu = dsus[d];
        dsu.union(p, q);
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
//            fa[q] = p;
            fa[p] = q;
        }
    }
}
/*
D. Connect the Dots
https://codeforces.com/contest/2020/problem/D

灵茶の试炼 2024-10-30
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)，表示一个 n 个点的图，一开始没有边。节点编号从 1 到 n。
然后输入 m(1≤m≤2e5) 和 m 个操作。
每个操作输入 a d k (1≤a≤a+k*d≤n, 1≤d≤10, 0≤k≤n)，表示一个等差数列 a,a+d,a+2d,...,a+k*d。
把等差数列中的所有点全部连起来。
输出 m 个操作之后，这个图有多少个连通块。

rating 1800
见 数据结构题单 中的 §7.5 区间并查集。
首先创建 10 个并查集，分别处理对应的 d。对于每个询问，做法同区间并查集。
然后把 10 个并查集合并起来，也就是把 i 和 find(i) 当作两个点，加到一个新的并查集中。
代码 https://codeforces.com/contest/2020/submission/285448837
代码备份（nugine.xyz）
======

Input
3
10 2
1 2 4
2 2 4
100 1
19 2 4
100 3
1 2 5
7 2 6
17 2 31
Output
2
96
61
 */
