package c286;

import java.util.Arrays;
import java.util.Scanner;

public class Abc286_e {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int INF = (int) 1e9;

    static class pair {
        int dis;
        long s;

        public pair(int dis, long s) {
            this.dis = dis;
            this.s = s;
        }
    }

    private static String solve() {
        pair[][] f = new pair[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.setAll(f[i], e -> new pair(0, 0));
        }
        for (int i = 0; i < n; i++) {
            int v = a[i];
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                char b = s.charAt(j);
                if (b == 'Y') {
                    f[i][j] = new pair(1, v);
                } else {
                    f[i][j].dis = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int d = f[i][k].dis + f[k][j].dis;
                    long s = f[i][k].s + f[k][j].s;
                    if (d < f[i][j].dis || d == f[i][j].dis && s > f[i][j].s) {
                        f[i][j] = new pair(d, s);
                    }
                }
            }
        }

        int q = scanner.nextInt();
        String[] output = new String[q];
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            pair p = f[v][w];
            if (p.dis == INF) {
                output[i] = "Impossible";
            } else {
                output[i] = p.dis + " " + (p.s + a[w]);
            }
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
E - Souvenir
https://atcoder.jp/contests/abc286/tasks/abc286_e

灵茶の试炼 2025-03-25
题目大意：
输入 n(2≤n≤300) 和长为 n 的数组 a(1≤a[i]≤1e9)，表示一个 n 个点的图，每个点的点权为 a[i]。
然后输入一个 n*n 的 YN 矩阵 g，其中 g[i][j]=Y 表示有一条从 i 到 j 的有向边，边权为 1；g[i][j]=N 表示没有 i 到 j 的有向边。保证 g[i][i]=N。
然后输入 q(1≤q≤n*(n-1)) 和 q 个询问，每个询问输入两个数 x 和 y，保证 x≠y，范围在 [1,n]。
对于每个询问，输出两个数：
1. 从 x 到 y 的最短路长度 d。
2. 在所有从 x 到 y 的长为 d 的路径中，路径点权之和的最大值。
如果无法从 x 到 y，改为输出 Impossible。

n 很小，用 Floyd 计算所有点对的最短路。
算的同时，维护从 i 到 j 的点权和的最大值。
注意 Floyd 是应用在边上的，为了计算路径点权之和，我们需要把点权放到边上。怎么做？
可以在初始化时，对于边 i->j，把点权 a[i] 放到 i->j 上。也就是说 i->j 保存边权和点权 a[i]。
最终回答询问时，把路径点权之和额外加上终点 y 的点权，就是最终答案。
代码 https://atcoder.jp/contests/abc286/submissions/63232504
======

Input 1
5
30 50 70 20 60
NYYNN
NNYNN
NNNYY
YNNNN
YNNNN
3
1 3
3 1
4 5
Output 1
1 100
2 160
3 180

Input 2
2
100 100
NN
NN
1
1 2
Output 2
Impossible
 */
