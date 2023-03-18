package c292;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc292_d {
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
            dsu.union(edge[0] - 1, edge[1] - 1);
            int fa = dsu.find(edge[0] - 1);
            dsu.edge[fa]++;
        }

        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            if (dsu.vertex[fa] != dsu.edge[fa]) {
                return "No";
            }
        }
        return "Yes";
    }

    private static class DSU {
        int[] fa;
        int[] vertex;
        int[] edge;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            vertex = new int[N];
            edge = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
                vertex[i] = 1;
            }
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
            // 合并到较小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
                vertex[rootP] += vertex[rootQ];
                edge[rootP] += edge[rootQ];
            } else {
                fa[rootP] = rootQ;
                vertex[rootQ] += vertex[rootP];
                edge[rootQ] += edge[rootP];
            }
        }
    }
}
/*
D - Unicyclic Components
https://atcoder.jp/contests/abc292/tasks/abc292_d

相似题目: D - Tying Rope
https://atcoder.jp/contests/abc293/tasks/abc293_d
 */