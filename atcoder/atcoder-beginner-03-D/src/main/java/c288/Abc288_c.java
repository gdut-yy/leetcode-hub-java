package c288;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc288_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, ab));
    }

    private static String solve(int n, int m, int[][] ab) {
        int ans = 0;
        DSU dsu = new DSU(n);
        for (int[] edge : ab) {
            int a = edge[0] - 1, b = edge[1] - 1;
            int fa = dsu.find(a);
            int fb = dsu.find(b);
            if (fa == fb) {
                ans++;
            } else {
                dsu.union(a, b);
            }
        }
        return String.valueOf(ans);
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
            // 路径压缩
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
        }
    }
}
/*
C - Don’t be cycle
https://atcoder.jp/contests/abc288/tasks/abc288_c

题目大意：
给定一个简单的无向图，有 N 个顶点和 M 条边。顶点编号为 1 到 N，第 i 条边连接顶点 i 和顶点 i。让我们删除零条或多条边来从图中删除循环。找出为此目的必须删除的边的最小数目。

并查集。
======

Input 1
6 7
1 2
1 3
2 3
4 2
6 5
4 6
4 5
Output 1
2

Input 2
4 2
1 2
3 4
Output 2
0

Input 3
5 3
1 2
1 3
2 3
Output 3
1
 */