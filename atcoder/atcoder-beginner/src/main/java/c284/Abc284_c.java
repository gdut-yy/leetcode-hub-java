package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, edges));
    }

    private static String solve(int n, int m, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            dsu.union(x, y);
        }
        return String.valueOf(dsu.sz);
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
C - Count Connected Components
https://atcoder.jp/contests/abc284/tasks/abc284_c

题目大意：
给你一个简单的无向图，有 N 个编号为 1 到 N 的顶点，M 条编号为 1 到 M 的边，边 i 连接着顶点 u i 和顶点 vi。
在这个图中找出连接组件的数量。

并查集。
======

Input 1
5 3
1 2
1 3
4 5
Output 1
2

Input 2
5 0
Output 2
5

Input 3
4 6
1 2
1 3
1 4
2 3
2 4
3 4
Output 3
1
 */