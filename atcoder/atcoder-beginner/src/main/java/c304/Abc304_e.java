package c304;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc304_e {
    static int n, m, k, q;
    static int[][] uv, xy, pq;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        uv = new int[m][2];
        for (int i = 0; i < m; i++) {
            uv[i][0] = scanner.nextInt() - 1;
            uv[i][1] = scanner.nextInt() - 1;
        }
        k = scanner.nextInt();
        xy = new int[k][2];
        for (int i = 0; i < k; i++) {
            xy[i][0] = scanner.nextInt() - 1;
            xy[i][1] = scanner.nextInt() - 1;
        }
        q = scanner.nextInt();
        pq = new int[q][2];
        for (int i = 0; i < q; i++) {
            pq[i][0] = scanner.nextInt() - 1;
            pq[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        DSU dsu = new DSU(n);
        for (int[] p : uv) {
            dsu.union(p[0], p[1]);
        }
        Set<Long> forbidden = new HashSet<>();
        for (int[] p : xy) {
            int xFa = dsu.find(p[0]);
            int yFa = dsu.find(p[1]);
            forbidden.add((long) xFa << 32 | yFa);
            forbidden.add((long) yFa << 32 | xFa);
        }

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int xFa = dsu.find(pq[i][0]);
            int yFa = dsu.find(pq[i][1]);
            long key = (long) xFa << 32 | yFa;
            ans[i] = forbidden.contains(key) ? "No" : "Yes";
        }
        return String.join(System.lineSeparator(), ans);
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int x, int y) {
            int xFa = find(x);
            int yFa = find(y);
            if (xFa == yFa) {
                return;
            }
            fa[yFa] = xFa;
        }
    }
}
/*
E - Good Graph
https://atcoder.jp/contests/abc304/tasks/abc304_e

题目大意：
给定一个无向图 G，它有 N 个顶点和 M 条边。对于 i=1,2,...,M，第 i 条边是连接顶点 ui 和 vi 的无向边。
一个有 N 个顶点的图被称为好图，如果以下条件对所有 i=1,2,...,K 都成立:
在 G 中没有连接顶点 xi 和 yi 的路径。
给定的图 G 是好的。
给你 Q 个独立的问题。全部回答。对于 i=1,2,...,Q，第 i 题如下。
图 G(i)是通过在给定的图 G 上添加一条连接顶点 pi 和 qi 的无向边得到的吗?

并查集。记录不能连接的连通块。
======

Input 1
6 6
1 2
2 3
2 3
3 1
5 4
5 5
3
1 5
2 6
4 3
4
2 5
2 6
5 6
5 4
Output 1
No
No
Yes
Yes
 */